<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工作台</title>
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
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/main.css" media="all">
</head>
</head>
<body>
<div class="layui-fluid larry-wrapper">
    <div class="layui-row layui-col-space20" id="infoSwitch">
        <div class="layui-col-xs12  layui-col-sm12  layui-col-md12  layui-col-lg12">
            <blockquote class="layui-elem-quote  head-con">
                <div>尊敬的${username}<span id="weather"></span></div>
                <i class="larry-icon close" id="closeInfo">&#xe707;</i>
            </blockquote>
        </div>
    </div>
    <!-- 快捷图标导航 -->
    <div class="layui-row layui-col-space20 larry-shortcut" id="shortcut">

        <div class="layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2 larry-col">
            <section class="panel pos-r larry-ico-rotate">
                <div class="inline-block layui-bg-red larry-ico"><i class="larry-icon">&#xe6aa;</i></div>
                <div class="inline-block right-value">
                    <a data-href="/showUser.action">
                        <h3 class="no-count">个人信息</h3>
                    </a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2 larry-col">
            <section class="panel pos-r larry-ico-rotate">
                <div class="inline-block layui-bg-blue larry-ico"><i class="larry-icon">&#xe795;</i></div>
                <div class="inline-block right-value">
                    <a data-href="/changePwd.action">
                        <h3 class="no-count">修改密码</h3>
                    </a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2 larry-col">
            <section class="panel pos-r larry-ico-rotate">
                <div class="inline-block layui-bg-pale larry-ico"><i class="larry-icon">&#xe616;</i></div>
                <div class="inline-block right-value">
                    <a data-href="${path}/systemUser.action">
                        <h3 class="no-count">用户管理</h3>
                    </a>
                </div>
            </section>
        </div>

        <div class="layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2 larry-col">
            <section class="panel pos-r larry-ico-rotate">
                <div class="inline-block layui-bg-red larry-ico"><i class="larry-icon">&#xe73a;</i></div>
                <div class="inline-block right-value">
                    <a data-href="subgroup/404.html">
                        <h3 class="no-count">404页面</h3>
                    </a>
                </div>
            </section>
        </div>
    </div>


    <div class="layui-row layui-col-space20">
        <!-- 提示 -->
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <blockquote class="layui-elem-quote tips-con">
                <p>
                   系统公告..........................................................
                </p>

            </blockquote>
        </div>

        <div class="layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
            <section class="larry-panel">
                <div class="larry-panel-header">
                    <div class="larry-panel-title inline-block">系统概览</div>
                    <div class="tools inline-block fr down"><i class="larry-icon">&#xe818;</i></div>
                </div>
                <div class="larry-panel-body">
                    <div class="larry-table">
                        <table class="layui-table larry-table-info">
                            <colgroup>
                                <col width="150">
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td><span class="tit">系统名称:</span></td>
                                <td><span class="info">怡翠地产系统</span></td>
                            </tr>
                            <tr>
                                <td><span class="tit">版本信息:</span></td>
                                <td><span class="info iframe">1.0</span></td>
                            </tr>

                            <tr>
                                <td><span class="tit">官网地址:</span></td>
                                <td><span class="info"><a href="#" class="official" target="_blank">怡翠地产</a></span></td>
                            </tr>

                            <tr>
                                <td><span class="tit">服务器环境:</span></td>
                                <td>centos6.5+tomcat8+jre1.8</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>

        <div class="layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
            <section class="larry-panel">
                <div class="larry-panel-header">
                    <div class="larry-panel-title inline-block">系统公告</div>
                    <div class="tools inline-block fr down"><i class="larry-icon">&#xe818;</i></div>
                </div>
                <div class="larry-panel-body layrr-document">
                    <fieldset class="layui-elem-field content">
                        <legend>计划</legend>
                        <div class="layui-field-box">
                            <p>
                                    销售计划...
                            <hr class="layui-bg-orange">
                                    楼盘计划.....
                            </p>
                        </div>
                    </fieldset>
                </div>
            </section>
        </div>

    </div>

</div>
<!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script type="text/javascript" src="${path}/backstage/js/main.js"></script>
<!--[if lt IE 9]>
<script src="${path}/common/js/html5.min.js"></script>
<script src="${path}/common/js/respond.min.js"></script>
<![endif]-->
</body>
</html>
