<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/10/6
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>授予角色</title>
    <link rel="stylesheet" type="text/css" href="${path}/common/frame/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/gobal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/animate.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/user.css" media="all">
    <style>
        .role {
            display: inline-block;
            width: 150px;
            background-color: #F2F2F2;
        }
    </style>
</head>
<body>
<div class="layui-fluid larry-wrapper">
    <div class="layui-row  animated bounceIn">
        <div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
            <form class="layui-form" action="">
                <input type="hidden" name="orgId" value="${orgId}"/>
                <input type="hidden" id="roleIds" name="roleIds" value="${roleIds}"/>
                <c:forEach items="${requestScope.roles}" var="role" varStatus="vs">
                    <div class="role">
                        <input type="checkbox" name="roleId" title="${role.roleName}" value="${role.roleId}">
                    </div>
                    <c:if test="${vs.count %5 ==0}">
                        <hr class="layui-bg-red">
                    </c:if>
                </c:forEach>
            </form>
            <br/>
            <br/>
            <button type="button" id="grantRole" class="layui-btn ">授予角色</button>
            <button type="button" id="close" class="layui-btn layui-btn-warm">返 回</button>
        </div>
    </div>
</div>

<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script type="text/javascript" src="${path}/assets/layer/layer.js"></script>
<script>
    $(function () {
        //角色信息回下
        var roleIdMsg = $('#roleIds').val();
        var roleIdArr = roleIdMsg.split(",");
        for (var i = 0; i < roleIdArr.length; i++) {
             $('input[value="' + roleIdArr[i] + '"]').attr('checked', 'checked');
        }
        var index = parent.layer.getFrameIndex(window.name);
        //关闭弹窗
        $('#close').click(function () {
            parent.layer.close(index);
        });
        $('#grantRole').click(function () {
            //角色授权
            //获取选中的角色
            var $roleArr = $('input[name="roleId"]:checked');
            var roleIds = [];
            for (var i = 0; i < $roleArr.length; i++) {
                roleIds.push($roleArr[i].value);
            }
            var url = '/grantRole.action';
            var data = 'orgId=' + $('input[name="orgId"]').val() + "&roleIds=" + roleIds;
            $.post(url, data, function (resp) {
                if (resp.code == 200) {
                    layer.msg('授予角色成功!', {icon: 1});
                    setTimeout(function () {
                        parent.layer.close(index);
                    }, 1500);
                } else {
                    layer.msg('授予角色失败!', {icon: 2});
                }
            });
        });
    });
</script>
</body>
</html>
