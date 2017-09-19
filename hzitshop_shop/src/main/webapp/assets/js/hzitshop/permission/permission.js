$(function(){
    var treeObj;
    $.get('/permissionAjaxTree.action', function (result) {
        var setting = {
            //页面上的显示效果
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            key:{
                name: "orgName"
            },
            check: {
                enable: true,
                //勾选 checkbox 对于父子节点的关联关系
                chkboxType: { "Y": "", "N": "" }  //Y 属性定义 checkbox 被勾选后的情况；
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
            //展开所有的节点
            treeObj.expandAll(true);
        });
    });


    //------------------------------layui start------------------------------------------------
    layui.use(['layer', 'form', 'table', 'common','jquery'], function() {
        var $ = layui.$,
            layer = layui.layer,
            form = layui.form,
            table = layui.table,
            common = layui.common,
            jquery=layui.jquery;
//*******************表格start************

        var tableIns = table.render({
            elem: '#orgTables',
            id:'orgTable',
            width:'auto',
            limits: [10,20,50,100],
            limit: 20, //默认采用60
            cols: [
                [{
                    checkbox: true,
                    width: 60,
                    fixed: true
                },{
                    field: 'name',
                    // edit:true,  //单元格编辑
                    width: 120,
                    title: '组织名称'
                },{
                    field: 'orgCode',
                    // edit:true,  //单元格编辑
                    width: 120,
                    title: '组织代码'
                },{
                    field: 'orgParentId',
                    // edit:true,  //单元格编辑
                    width: 120,
                    title: '父级'
                },{
                    field:'description',
                    title:'描述',
                    width:100
                },{
                    field:'createBy',
                    title:"录入人",
                    width:80
                },{
                    field:'createTime',
                    title:'录入时间',
                    width:180
                },{
                    field:'updateBy',
                    title:'修改人',
                    width:80
                },{
                    field:'updateTime',
                    title:'修改时间',
                    width:180
                }]

            ],
            url: '/orgAjax.action',
            page: true,
            even: true,

        });
//*******************表格end************


        $('#larry_group .layui-btn').on('click',function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        var active = {
            add:function(){//添加用户信息
                //common.larryCmsMessage('最近好累，还是过段时间在写吧！','error');
                //先获取要添加的组织的父级编号和名称
                var checkNodes = treeObj.getCheckedNodes(true);//获取所有勾选的节点
                if(checkNodes.length == 0){
                    layer.msg('请选择要添加子节点的节点!',{icon:3});
                }else if(checkNodes.length >1){
                    layer.msg('所选节点不能大于1个,请选择一个具体的节点!',{icon:3});
                }else{
                    //获取父级组织编号和名称
                    var pid = checkNodes[0].id;  //组织编号
                    var pName =checkNodes[0].title;//组织名称
                    var param = '?pid='+ pid+"&pName="+pName;
                    layer.open({
                        type: 2,
                        title: '添加权限信息',
                        shadeClose: true,
                        shade: false,
                        maxmin: true,
                        area: ['100%', '100%'],
                        content: '/addPermission.action'+param //iframe的url
                    });
                }

                //location.href ='/addOrg.action';
            },edit:function(){//批量删除数据
                var checkNodes = treeObj.getCheckedNodes(true);//获取所有勾选的节点
                if(checkNodes.length == 0){
                    layer.msg('请选择要编辑节点!',{icon:3});
                }else if(checkNodes.length >1){
                    layer.msg('所选节点不能大于1个,请选择一个具体的节点!',{icon:3});
                }else{
                    //获取父级组织编号和名称
                    var orgId = checkNodes[0].orgId;
                    var param = '?orgId='+orgId;
                    layer.open({
                        type: 2,
                        title: '编辑权限信息',
                        shadeClose: true,
                        shade: false,
                        maxmin: true,
                        area: ['500px', '500px'],
                        content: '/editPermission.action'+param //iframe的url
                    });
                }
            },
            expand:function(){     //展开
                treeObj.expandAll(true);//true表示展开
            },
            close:function(){
                treeObj.expandAll(false);//收缩
            }
        };
    });

    //-----------------------------layui end -------------------------------------------------

});

