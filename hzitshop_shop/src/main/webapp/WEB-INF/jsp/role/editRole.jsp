<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/9/17
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改角色</title>
    <meta name="keywords" content="" />
    <meta name="description" content="LarryCMS Version:1.09" />
    <meta name="Author" content="larry" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${path}/common/frame/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/gobal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/animate.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/sys.css" media="all">
</head>
</head>
<body>
<div class="larry-grid larry-wrapper">
    <form id="editRole" class="layui-form" action="/editRole.action" method="post">
        <input type="hidden" value="${role.roleId}" name="roleId"/>
        <div class="layui-form-item">
            <label class="layui-form-label">角色名:</label>
            <div class="layui-input-block">
                <input type="text" name="roleName" value="${role.roleName}"   lay-verify="required" placeholder="请输入角色!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <!--是否禁用-->
        <div class="layui-form-item">
            <label class="layui-form-label">是否禁用:</label>
            <div class="layui-input-block">
                <input type="radio" name="isLock" value="1" title="启用" <c:if test="${role.isLock == '1'}">checked</c:if>/>
                <input type="radio" name="isLock" value="0" title="禁用" <c:if test="${role.isLock == '0'}">checked</c:if>/>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述:</label>
            <div class="layui-input-block">
                <textarea name="description" placeholder="请输入内容!" class="layui-textarea">${role.description}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn"lay-submit lay-filter="add">保 存</button>
                <button type="reset" class="layui-btn layui-btn-normal">重 置</button>
                <button type="button" id="goback" class="layui-btn layui-btn-warm">返 回</button>
            </div>
        </div>
    </form>


</div>
<!-- 加载js文件 -->
<script src="${path}/common/js/jquery-1.12.4.min.js"></script>
<script src="${path}/assets/layer/layer.js"></script>
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script>
    $(function(){
        $('#goback').click(function(){
            history.go(-1);
        });
        layui.use('form', function(){
            var form = layui.form;
            //监听提交
            form.on('submit(add)', function(data){
                //layer.msg(JSON.stringify(data.field));
                $.ajax({
                    method:'post',
                    url:'/editRole.action',
                    data:$('#editRole').serialize(),
                    success:function(resp){
                        if(resp.code === 200){
                            layer.msg(resp.msg,{icon:1});
                            setTimeout(function(){
                                history.go(-1);
                            },1500);
                        }else{
                            layer.msg(resp.msg,{icon:2});
                        }
                    }
                })
                return false;
            });
        });
    });
</script>
</body>
</html>
