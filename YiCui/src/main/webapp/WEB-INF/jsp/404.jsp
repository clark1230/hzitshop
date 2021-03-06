<%--
  Created by IntelliJ IDEA.
  User: xianyaoji
  Date: 2017/9/21
  Time: 17:17
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
    <title>页面找不到!</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
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
    <style type="text/css" media="screen">
        body{background: #ffffff;overflow-x: hidden;}
        .larry-grid{
            background: #ffffff;
            padding-top: 100px;
        }
        .larry-box{
            padding-left: 50px;
            padding-right: 50px;
            margin: 0 auto;
            text-align: center;
        }
        .left{
            padding-right: 80px;
        }
        .left h1{
            padding-top: 135px;
            font-size: 60px;
            font-weight: 700;
            color: #d31117;
            margin-bottom: 20px;
        }
        .left h2{
            display: block;
            font-size: 1.5em;
            -webkit-margin-before: 0.83em;
            -webkit-margin-after: 0.83em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            font-weight: bold;
            color: #3b86ff;
        }
    </style>
</head>
</head>
<body>
<div class="larry-grid larry-wrapper">
    <div class="larry-box clearfix ">
        <div class="inline-block left animated fadeInLeft">
            <h1>  404!</h1>
            <h2>我勒个去，页面被外星人劫持了!</h2>
        </div>
        <div class="inline-block right animated LarryRight">
            <a href="#" data-ke-src="#" data-ke-onclick="go();"><img src="${path}/common/images/404.gif" alt=""></a>
        </div>
    </div>
</div>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
</body>
</html>