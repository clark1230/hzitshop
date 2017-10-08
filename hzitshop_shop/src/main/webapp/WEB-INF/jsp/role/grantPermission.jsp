<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色授权</title>
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${path}/common/frame/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/gobal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/animate.css" media="all">

    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/user.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/assets/ztree/css/zTreeStyle/zTreeStyle.css" media="all">
    <style>
        .disabled {
            background-color: lightgray;
        }

    </style>
</head>
<body>
<div class="layui-fluid larry-wrapper">
    <div class="layui-row  animated bounceIn">
        <div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
            <input type="hidden" id="roleIds" name="roleIds" value="${roleIds}"/>
            <div class="layui-inline">
                <button class="layui-btn layui-btn-normal disabled" id="expandAll" disabled="disabled"><i
                        class="layui-icon">&#xe61a;</i><cite>展开</cite></button>
            </div>
            <div class="layui-inline">
                <button class="layui-btn layui-btn-normal" id="unExpandAll"><i
                        class="layui-icon">&#xe619;</i><cite>收缩</cite></button>
            </div>
            <div class="layui-inline">
                <button class="layui-btn " id="checkd"><i class="layui-icon">&#xe618;</i><cite>全部勾选</cite></button>
            </div>
            <div class="layui-inline">
                <button class="layui-btn layui-btn-warm" id="unChecked"><i class="layui-icon">&#x1006;</i><cite>取消勾选</cite></button>
            </div>

            <ul id="tree" class="ztree">

            </ul>
            <button id="grantPermission" class="layui-btn layui-btn-normal">授 权</button>
            <button id="close" class="layui-btn layui-btn-warm">返 回</button>
        </div>
    </div>
</div>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path}/assets/ztree/jquery.ztree.all.js"></script>
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script type="text/javascript" src="${path}/assets/layer/layer.js"></script>
<script>
    $(function () {
        var treeObj;
        var index = parent.layer.getFrameIndex(window.name);
        showTree();

        function showTree() {
            $.get('/permissionAjaxTree.action', function (result) {
                var setting = {
                    //页面上的显示效果
                    view: {
                        dblClickExpand: false,
                        showLine: true,
                        selectedMulti: false
                    },
                    key: {
                        name: "orgName"
                    },
                    check: {
                        enable: true,
                        //勾选 checkbox 对于父子节点的关联关系
                        chkboxType: {"Y": "", "N": ""}  //Y 属性定义 checkbox 被勾选后的情况；
                        //N 属性定义 checkbox 取消勾选后的情况；
                        //"p" 表示操作会影响父级节点；
                        //"s" 表示操作会影响子级节点。
                        //请注意大小写，不要改变
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "pid",
                            rootPId: 0
                        }
                    }
                };

                $(function () {
                    treeObj = $.fn.zTree.init($("#tree"), setting, result);
                    checkNode();
                    //展开所有的节点
                    treeObj.expandAll(true);
                });
            });
        }


        //选择的权限信息回显

        //授权
        $('#grantPermission').click(function () {
            //获取选中的权限信息
            //获取所有已经选中的节点
            var treeObj = $.fn.zTree.getZTreeObj("tree"), nodes = treeObj.getCheckedNodes(true), ids = "",
                description = '';
            if (nodes.length < 1) {
                layer.alert('请选择要授权的模块!');
                return false;
            }
            var ids = [];
            //权限编号信息
            for (var i = 0; i < nodes.length; i++) {
                ids.push(nodes[i].id);

            }
            var index2 = layer.load(0, {time: 15 * 1000}, {shade: false}); //0代表加载的风格，支持0-2
            //一步提交数据
            $.ajax({
                method: 'post',
                url: 'grantPermission.action',
                data: "roleIds=" + $("#roleIds").val() + "&perIds=" + ids,
                success: function (result) {
                    layer.close(index2);
                    if (result.code != 200) {
                        layer.msg(result.msg);
                    } else {
                        layer.msg(result.msg);
                        window.setTimeout(function () {//iframe 1秒后关闭
                            parent.layer.close(index);//关闭层
                        }, 2000);
                    }
                }
            });
        });

        //关闭窗口
        $('#close').click(function () {
            parent.layer.close(index);
        });

        $('#expandAll').click(function () {
            treeObj.expandAll(true);//true表示展开
            $('#expandAll').attr('disabled', 'disabled').addClass('disabled');
            $('#unExpandAll').removeAttr("disabled").removeClass('disabled');
        });
        //收缩全部节点
        $('#unExpandAll').click(function () {
            treeObj.expandAll(false);//收缩
            //启用展开按钮
            $('#expandAll').removeAttr("disabled").removeClass('disabled');
            //禁用收缩按钮
            $('#unExpandAll').attr('disabled', 'disabled').addClass('disabled');
        });
        //取消勾选
        $('#unChecked').click(function () {
            $.fn.zTree.getZTreeObj("tree").checkAllNodes(false);
        });
        $('#checkd').click(function(){
            $.fn.zTree.getZTreeObj("tree").checkAllNodes(true);
        });

        /**
         * 页面加载时查看有哪些权限
         */
        function checkNode() {
            //页面加载时获取该角色的模块信息
            $.get('/checkPermission.action?roleIds=' + $("#roleIds").val(), function (result) {
                var treeObj = $.fn.zTree.getZTreeObj("tree");
                if (result != 'null') {
                    if (result.length > 0) {
                        for (var i = 0; i < result.length; i++) {
                            treeObj.checkNode(treeObj.getNodeByParam("id", result[i], null), true, false);
                        }
                    }
                }
            });
        }
    });
</script>
</body>
</html>
