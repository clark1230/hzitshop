<%--
  Created by IntelliJ IDEA.
  User: xianyaoji
  Date: 2017/9/18
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑组织</title>
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
    <style>
        .form{
            padding:20px;
        }
    </style>
</head>
</head>
<body>
<div class="larry-grid larry-wrapper">
    <form id="editOrg" class="layui-form form" action="/addOrg.action" method="post">
        <input type="hidden" name="orgId" value="${org.orgId}"/>
        <div class="layui-form-item">
            <label class="layui-form-label">组织名:</label>
            <div class="layui-input-block">
                <input type="text" name="name" value="${org.name}"  lay-verify="required" placeholder="请输入组织名称!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">组织代码:</label>
            <div class="layui-input-block">
                <input type="text" name="orgCode" value="${org.orgCode}"  lay-verify="required" placeholder="请输入组织代码!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <!--父级组织名称-->
        <div class="layui-form-item">
            <label class="layui-form-label">父级组织名:</label>
            <div class="layui-input-block">
                <select name="orgParentId" >
                    <option value=""></option>
                    <c:forEach items="${orgList}" var="org2">
                        <option value="${org2.orgId}" <c:if test="${org.orgParentId ==org2.orgId}">selected</c:if>>${org2.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <!--组织类型-->
        <div class="layui-input-block">
            <select name="type" >
                <option value=""></option>
                <option value="公司" <c:if test="${org.type =='公司'}">selected</c:if>>公司</option>
                <option value="部门" <c:if test="${org.type =='部门'}">selected</c:if>>部门</option>
                <option value="岗位" <c:if test="${org.type =='岗位'}">selected</c:if>>岗位</option>
            </select>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述:</label>
            <div class="layui-input-block">
                <textarea name="description" placeholder="请输入内容!" class="layui-textarea">${org.description}</textarea>
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
        var  index = parent.layer.getFrameIndex(window.name);
        $('#goback').click(function(){
            //history.go(-1);
            //关闭窗体
            parent.layer.close(index);
        });
        layui.use('form', function(){
            var form = layui.form;
            //监听提交
            form.on('submit(add)', function(data){
                //layer.msg(JSON.stringify(data.field));
                $.ajax({
                    method:'post',
                    url:'/editOrg.action',
                    data:$('#editOrg').serialize(),
                    success:function(resp){
                        if(resp.code === 200){
                            layer.msg(resp.msg,{icon:1});
                            setTimeout(function() {
                                parent.layer.close(index);   //关闭窗体
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
