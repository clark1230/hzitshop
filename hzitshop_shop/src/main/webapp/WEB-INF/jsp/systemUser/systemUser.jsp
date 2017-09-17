<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/9/16
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <meta name="keywords" content="" />
    <meta name="description" content="hzitxx" />
    <meta name="Author" content="larry" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${path}/common/frame/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/gobal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/animate.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/user.css" media="all">

</head>
<body>
<div class="layui-fluid larry-wrapper">
    <div class="layui-row  animated bounceIn">
        <div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
            <%--<div class="layui-btn-group larry-group" >--%>
                <div class="" id="larry_group">
                    <div class="layui-inline">
                        <button class="layui-btn"  data-type="add"><i class="layui-icon">&#xe61f;</i><cite>增加用户</cite></button>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-danger"  data-type="del"><i class="layui-icon">&#xe640;</i><cite>(批量)删除</cite></button>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal"  data-type="grant"><i class="layui-icon">&#xe613;</i><cite>(批量)授权</cite></button>
                    </div>
                    <div class="layui-input-inline" style="display: inline-block;">
                        <input type="text" name="search" value="" id="search_input" placeholder="请输入搜索内容!" class="layui-input">
                    </div>
                    <a class="layui-btn search_btn layui-btn-normal" data-type="getSelect"><i class="layui-icon">&#xe615;</i>查询</a>
                </div>
            <%--</div>--%>

        </div>

        <div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
            <div class="user-tables">
                <table id="userTables" lay-filter="userTables"></table>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="userbar">
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn  layui-btn-mini" lay-event="shouquan">授权</a>
    <!-- laytpl 语法，-->
    {{#  if(d.isLock == 0){ }}
        <a class="layui-btn layui-btn-normal  layui-btn-mini"  lay-event="disable">启用</a>
    {{#  } }}
    {{#  if(d.isLock == 1){ }}
    <a class="layui-btn layui-btn-warm  layui-btn-mini"  lay-event="disable">禁用</a>
    {{#  } }}
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>

</script>

<script type="text/html" id="isLockTpl">
    {{#  if(d.isLock == 0){ }}
    <span class="layui-badge layui-bg-orange">禁用</span>
    {{#  } else { }}
    <span class="layui-badge layui-bg-blue">启用</span>
    {{#  } }}
</script>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script type="text/javascript" src="${path}/assets/js/hzitshop/systemUser/systemUser.js"></script>
</body>
</html>
