<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/9/9
  Time: 18:00
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
    <title>合众艾特后台管理系统</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="Shortcut Icon" href="${path}/favicon.ico" />
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${path}/common/frame/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/common/css/gobal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${path}/backstage/css/backstage.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin larrycms-admin" id="larry_admin_out">
    <!-- 顶部导航 -->
    <div class="layui-header larrycms-header">
        <div class="layui-logo larrycms-logo">
            <!-- <img src="../common/images/logo.png"> -->
            合众艾特
        </div>
        <!-- 右侧 -->
        <div class="larrycms-top pos-a">
            <div class="menu-switch pos-a" id="menuSwitch"><i class="larry-icon pos-a fz20">&#xe6d6;</i></div>
            <div class="menu-mobile pos-a" id="larryMobile"><i class="larry-icon pos-a fz20">&#xe6d6;</i></div>
            <!-- 顶级菜单 -->
            <div class="inline-block larrycms-top-menu pos-a">
                <ul class="layui-nav clearfix" id="larry_top_menu" lay-filter="TopMenu">
                    <!-- 此次动态生成 -->
                </ul>
            </div>
            <!-- 右侧常用菜单 -->
            <div class="inline-block larrycms-offten-menu pos-a">
                <ul class="layui-nav clearfix">
                    <li class="layui-nav-item">
                        <a id="FullScreen" class="onFullScreen"><i class="larry-icon">&#xe604;</i>全屏</a>
                    </li>
                    <li class="layui-nav-item">
                        <a id="lock"><i class="larry-icon">&#xe6a7;</i>锁屏</a>
                    </li>
                    <li class="layui-nav-item">
                        <a id="clearCached"><i class="larry-icon">&#xe659;</i>清除缓存</a>
                    </li>
                    <li class="layui-nav-item">
                        <a id="larryTheme"><i class="larry-icon">&#xe66f;</i>设置主题</a>
                    </li>
                    <li class="layui-nav-item exit">
                        <a id="logout"><i class="larry-icon">&#xe62c;</i><cite>退出</cite></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- 左侧区域 -->
    <div class="layui-side pos-a larrycms-left layui-bg-black" id="larry_left">
        <div class="layui-side-scroll">
            <!-- 管理员信息      -->
            <div class="user-info">
                <div class="photo">
                    <img src="${path}/assets/images/user.png" alt="">
                </div>
                <p>${username}您好！欢迎登录</p>
            </div>
            <!-- 系统菜单 -->
            <div class="sys-menu-box" >
                <ul class="layui-nav layui-nav-tree" id="larry_left_menu" lay-filter="LarrySide" data-group='0'>
                    <!-- 此次动态生成 -->
                </ul>
            </div>
        </div>
    </div>
    <!-- 内容主体区域 -->
    <div class="layui-body pos-a larrycms-body" id="larry_body">
        <div class="layui-tab larrycms-tab" id="larry_tab" lay-filter="larryTab">
            <div class="larrycms-title-box"></div>
            <div class="go-left">
                <div class="key-press pressKey" id="titleLeft" title="滚动至最右侧"><i class="larry-icon">&#xe6fd;</i></div>
            </div>
            <ul class="layui-tab-title larrycms-tab-title" lay-allowclose="true" id="larry_tab_title" lay-filter="subadd">
                <li class="layui-this" id="admin-home" lay-id="0" fresh="1">
                    <i class="larry-icon">&#xe697;</i><em>工作台</em>
                </li>
            </ul>
            <div class="title-right" id="titleRbox">
                <div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i class="larry-icon">&#xe6fb;</i></div>
                <div class="refresh key-press" id="refresh_iframe">
                    <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#x1002;</i>
                    <cite>刷新</cite>
                </div>
                <div class="often key-press" lay-filter="larryOperate" id="buttonRCtrl">
                    <ul class="layui-nav pos-r">
                        <li class="layui-nav-item pos-a">
                            <a class="top"><i class="larry-icon">&#xe705;</i><cite>常用操作</cite><span class="layui-nav-more"></span></a>
                            <dl class="layui-nav-child layui-anim layui-anim-upbit">
                                <dd id="tabCtrD">
                                    <a data-ename="positionCurrent"><i class="larry-icon">&#xe710;</i>定位当前选项卡</a>
                                </dd>
                                <dd id="tabCtrA">
                                    <a data-ename="closeCurrent"><i class="larry-icon">&#xe710;</i>关闭当前选项卡</a>
                                </dd>
                                <dd id="tabCtrB">
                                    <a data-ename="closeOther"><i class="larry-icon">&#xe711;</i>关闭其他选项卡</a>
                                </dd>
                                <dd id="tabCtrC">
                                    <a data-ename="closeAll"><i class="larry-icon">&#xe702;</i>关闭全部选项卡</a>
                                </dd>
                                <dd>
                                    <a data-ename="refreshAdmin"><i class="larry-icon">&#xe700;</i>刷新最外层框架</a>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="layui-tab-content" id="larry_tab_content">
                <div class="layui-tab-item layui-show">
                    <iframe class="larry-iframe" data-id='0' name="ifr_0" id='ifr0'  src="${path}/main.action"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部固定区域 -->
    <div class="layui-footer pos-a larrycms-footer" id="larry_footer">
        <div class="layui-main">
            <p class="inline-block">©2017 <a href="#" target="_blank" class="fp">hzitxx.com</a>版权信息</p>
        </div>
    </div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/common/js/gobal.js"></script>
<script type="text/javascript" src="${path}/backstage/js/larrycms.js"></script>
<!-- 主题配置 -->
<div class="larryThemeContent" id="LarryThemeSet" style="display:none;">
    <div class="larry-theme-form">
        <h3>系统主题设置</h3>
        <form action="" class="layui-form larry-theme-con">
            <div class="layui-form-item select-theme">
                <label class="layui-form-label">主题选择</label>
                <div class="layui-input-block">
                    <select lay-filter="larryTheme"  lay-verify="" id="themeName">
                        <option value="larry">默认主题</option>
                        <option value="A">深蓝主题</option>
                        <option value="B">墨绿主题</option>
                        <option value="C">藏青主题</option>
                        <%--<option value="larry_">我要自定义主题</option>--%>
                    </select>
                </div>
            </div>
            <div class="layui-form-item fullscreen">
                <label class="layui-form-label">是否全屏</label>
                <div class="layui-input-block">
                    <input type="checkbox" id="checkboxfull" lay-filter="fullscreen" lay-skin="switch"  value="1">
                </div>
            </div>
            <div class="layui-form-item tabSession">
                <label class="layui-form-label">开启Tab缓存</label>
                <div class="layui-input-block">
                    <input type="checkbox" id="checkboxtabSession" lay-filter="tabSession" lay-skin="switch"  value="1">
                </div>
                <span>开启后,将保持选项卡状态</span>
            </div>
            <div class="layui-form-item autoRefresh">
                <label class="layui-form-label">Tab切换刷新</label>
                <div class="layui-input-block">
                    <input type="checkbox" id="autoRefresh" lay-filter="autoRefresh" lay-skin="switch"  value="1">
                </div>
                <span>设置在切换tab选项卡重新打开时是否刷新</span>
            </div>
            <div class="layui-form-item submit-form">
                <button class="layui-btn larry-button" lay-submit="" lay-filter="submitlocal">立即设置主题</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置当前修改</button>
            </div>
        </form>
    </div>
</div>
<!-- 屏幕锁屏 -->
<div class="lock-screen" style="display: none;">
    <div class="lock-wrapper" id="lock-screen">
        <div id="time"></div>
        <div class="lock-box">
            <img src="${path}/backstage/images/user.jpg" alt="">
            <h1>admin</h1>
            <form action="" class="layui-form lock-form">
                <div class="layui-form-item">
                    <input type="password" id="unlock_pass" name="lock_password" lay-verify="pass" placeholder="锁屏状态，请输入密码解锁" autocomplete="off" class="layui-input"  autofocus="">
                </div>
                <div class="layui-form-item">
                    <span class="layui-btn larry-btn" id="unlock">立即解锁</span>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>