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
                <div class="inline-block layui-bg-green larry-ico"><i class="larry-icon">&#xe7ca;</i></div>
                <div class="inline-block right-value">
                    <a data-href="subgroup/larryfont.html">
                        <h3 class="no-count">LarryMS图标库</h3>
                    </a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2 larry-col">
            <section class="panel pos-r larry-ico-rotate">
                <div class="inline-block layui-bg-red larry-ico"><i class="larry-icon">&#xe6aa;</i></div>
                <div class="inline-block right-value">
                    <a data-href="html/content/article_list.html">
                        <h3 class="no-count">所有档案列表</h3>
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
                <div class="inline-block layui-bg-orange larry-ico"><i class="larry-icon">&#xe7d5;</i></div>
                <div class="inline-block right-value">
                    <a data-href="subgroup/hover.html">
                        <h3 class="no-count">Hover页面</h3>
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
                                <td><span class="info">LarryMS</span></td>
                            </tr>
                            <tr>
                                <td><span class="tit">版本信息:</span></td>
                                <td><span class="info iframe"> LarryMS v2.01 ( iframe版 )</span></td>
                            </tr>
                            <tr>
                                <td><span class="tit">开发作者:</span></td>
                                <td>Larry</td>
                            </tr>
                            <tr>
                                <td><span class="tit">官网地址:</span></td>
                                <td><span class="info"><a href="https://www.larrycms.com" class="official" target="_blank">https://www.larrycms.com</a></span></td>
                            </tr>

                            <tr>
                                <td><span class="tit">服务器环境:</span></td>
                                <td>PHP 7.2 + MySQL5.7 + Apache2.4.27</td>
                            </tr>
                            <tr>
                                <td><span class="tit">系统源码下载:</span></td>
                                <td>
                                    <a href="https://jq.qq.com/?_wv=1027&amp;k=42fC4vT" target="_blank" class="layui-btn layui-btn-small">加QQ群下载源码</a> <em class='qq-add'>Layui后台开发交流群号：493153642</em>
                                </td>
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
                        <legend>下个版本更新计划</legend>
                        <div class="layui-field-box">
                            <p>
                                整体后台基础框架功能已逐步完善，后续版本更新重点将放在完成整套CMS系统相关子页面的完成和性能优化上，持续更新的源码会发布在Layui后台开发群内；进而转入后台程序开发，结合Thinkphp框架+Layim完成整套预计年内完成LarryCMS系统，larryCMS系统完整php源码在完成后会分享在larryMS会员群内。感谢大家的关注和支持！<br>点这里访问：<a href="http://www.larrycms.com" target="_blank">larrycms官网</a><br>
                            <hr class="layui-bg-orange">
                            <span style="color:#FF5722; ">后期更新待续：</span>当前larryMS2.0版还有一些细节待完善：容错性测试，功能上如选项卡操作：关闭当前左侧选项卡、关闭当前右侧选项卡、返回上一步打开的选项卡(返回)、返回后前进...等小功能以及性能优化，这些在后面都会持续更新，另外关于后台布局，当前社区案例中与后台相关的风格几乎趋于一致，但完整实用的案例较少屈指可数，若此版本能得到较好认可与支持，后续将努力推出完全基于layui更多风格的后台模板案例（同时接受模板定制），同时也期待官方出品的layuiMS，再次感谢大家的关注与支持！ <a href="http://fly.layui.com/case/2017/" target="_blank" class="layui-btn layui-btn-mini">给larryCMS点个赞</a>
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
