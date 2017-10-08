<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="Author" content="larry"/>
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
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/mypanel.css" media="all">
</head>
</head>
<body>
<div class="larry-fluid larry-wrapper">
    <div class="layui-row lay-col-space20">
        <div class="layui-cos-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <section class="larry-body animated fadeInRightBig">
                <div class="larry-body-header">
                    <span class="tit">修改密码</span>
                </div>
                <div class="larry-body-content clearfix">
                    <form id="editPwdForm" class="layui-form" action="" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">原密码:</label>
                            <div class="layui-input-block">
                                <input type="text" name="oldPwd" lay-verify="required" autocomplete="off"
                                       class="layui-input "/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">新密码:</label>
                            <div class="layui-input-block">
                                <input type="text" name="newPwd" lay-verify="required" autocomplete="off"
                                       class="layui-input "/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">校验密码:</label>
                            <div class="layui-input-block">
                                <input type="text" name="newPwd2" lay-verify="required" autocomplete="off"
                                       class="layui-input "/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button type="button" class="layui-btn" lay-submit lay-filter="add">保 存</button>
                                <button type="reset" class="layui-btn layui-btn-normal">重 置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </div>
    </div>
</div>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script src="${path}/common/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${path}/backstage/js/mypanel.js"></script>
<script>
    $(function () {
        $('#goback').click(function () {
            history.go(-1);
        });
        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(add)', function (data) {
                $.ajax({
                    method: 'post',
                    url: '/changePwd.action',
                    data: $('#editPwdForm').serialize(),
                    success: function (resp) {
                        if (resp.code === 200) {
                            layer.msg(resp.msg, {icon: 1});
                        } else {
                            layer.msg(resp.msg, {icon: 2});
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
