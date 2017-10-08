<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/10/4
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>锁定屏幕</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="Shortcut Icon" href="${path}/favicon.ico"/>
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${path}/common/frame/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/gobal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/backstage.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin larrycms-admin" id="larry_admin_out">
    <!-- 屏幕锁屏 -->
    <div class="lock-screen" style="display: none;">
        <div class="lock-wrapper" id="lock-screen">
            <div id="time"></div>
            <div class="lock-box">
                <img src="${path}/assets/images/user.png" alt="">
                <h1>admin</h1>
                <form action="" class="layui-form lock-form">
                    <div class="layui-form-item">
                        <input type="password" id="unlock_pass" name="lock_password" lay-verify="pass"
                               placeholder="锁屏状态，请输入密码解锁" autocomplete="off" class="layui-input" autofocus="">
                    </div>
                    <div class="layui-form-item">
                        <span class="layui-btn larry-btn  layui-btn-warm" id="unlock">立即解锁</span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/common/js/gobal.js"></script>
<%--<script type="text/javascript" src="${path}/backstage/js/larrycms.js"></script>--%>
</body>
</html>
