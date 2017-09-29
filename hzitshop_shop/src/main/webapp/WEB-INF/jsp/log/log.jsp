<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/9/17
  Time: 15:07
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
    <title>系统日志管理</title>
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
            <div class="" id="larry_group">
                <div class="layui-input-inline" style="display: inline-block;">
                    <input type="text" name="search" value="" id="search_input" placeholder="请输入搜索内容!" class="layui-input">
                </div>
                <a class="layui-btn search_btn layui-btn-normal" data-type="getSelect"><i class="layui-icon">&#xe615;</i>查询</a>
            </div>
        </div>

        <div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
            <div class="user-tables">
                <table id="logTables" lay-filter="logTables"></table>
            </div>
        </div>
    </div>
</div>
<!--操作结果模板-->
<script type="text/html" id="commitTpl">
    {{#  if(d.commit == 'success'){ }}
    <span class="layui-badge layui-bg-blue">成功</span>
    {{#  } else { }}
        <span class="layui-badge">失败</span>
    {{#  } }}
</script>
<!--响应时间操作结果-->
<script type="text/html" id="responseDateTpl">
    {{#  if(d.responseDate >100){ }}  <%-- 响应时间大于100毫秒使用红色标注 --%>
        <span class="layui-badge">{{d.responseDate}}</span>
    {{#  } else { }}
            <span class="layui-badge layui-bg-blue">{{d.responseDate}}</span>
    {{#  } }}
</script>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script type="text/javascript" src="${path}/assets/js/hzitshop/log/log.js"></script>
</body>
</html>

