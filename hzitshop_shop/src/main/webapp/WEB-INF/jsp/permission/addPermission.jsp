<%--
  Created by IntelliJ IDEA.
  User: xianyaoji
  Date: 2017/9/18
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加组织</title>
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
    <link rel="stylesheet" type="text/css" href="${path}/backstage/subgroup/fontdemo.css">
    <style>
        .form{
            padding:20px;
        }
        .icon{
            display: none;
            clear: both;
            position: absolute;/*绝对定位*/
            background-color: #F2F2F2;
            z-index:100000;
            /*height: 400px;*/
        }
        .icon-ul{
            width:100%;
            height: 500px;
            overflow: scroll;
        }
        .icon-size{
            font-size:50px;
        }
        .icon-ul li{
            width:80px;
            /*height: 80px;*/
            display: inline-block;
            text-align: center;
            cursor: pointer;
            /*color:green;*/
            border:1px solid white;
            padding:2px;
        }
        .icon-ul li  i{
            font-size: 30px;
        }
        .icon-ul li:hover{
            /*color:orange;*/
            background-color: #1E9FFF;
        }
        /*在图标文本框上通过定位展示文本框*/
        .icon-show{
            position: absolute;
            /*background-color: red;*/
            right: 0;
            color:#1E9FFF;
            top:-14px;
            width:50px;
            height: 50px;
        }
    </style>
</head>
</head>
<body>
<div class="larry-grid larry-wrapper">
    <form id="addPermission" class="layui-form form" action="/addPermission.action" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">权限名:</label>
            <div class="layui-input-block">
                <input type="text" name="title"   lay-verify="required" placeholder="请输入权限名称!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图标:</label>
            <div class="layui-input-block" style="position:relative;"id="showIcon">
                <input type="text" name="icon" id="icon"  lay-verify="required" placeholder="请输入图标名称!" autocomplete="off" class="layui-input">
                <div class="icon"  id="iconDiv">
                    <ul class="icon-ul" id="icon-list">
                        <li>
                            <i class="larry-icon">&#xe743;</i>
                            <div class="name">网站管理</div>
                            <div class="code">&amp;#xe743;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe684;</i>
                            <div class="name">盟</div>
                            <div class="code">&amp;#xe684;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe712;</i>
                            <div class="name">编辑</div>
                            <div class="code">&amp;#xe712;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe713;</i>
                            <div class="name">编辑</div>
                            <div class="code">&amp;#xe713;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe744;</i>
                            <div class="name">QQ</div>
                            <div class="code">&amp;#xe744;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6fa;</i>
                            <div class="name">刷新</div>
                            <div class="code">&amp;#xe6fa;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe600;</i>
                            <div class="name">退出</div>
                            <div class="code">&amp;#xe600;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe77e;</i>
                            <div class="name">微信 方形</div>
                            <div class="code">&amp;#xe77e;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe664;</i>
                            <div class="name">清除缓存</div>
                            <div class="code">&amp;#xe664;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe714;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe714;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe68d;</i>
                            <div class="name">下载</div>
                            <div class="code">&amp;#xe68d;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe715;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe715;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe68e;</i>
                            <div class="name">失败</div>
                            <div class="code">&amp;#xe68e;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe601;</i>
                            <div class="name">日志</div>
                            <div class="code">&amp;#xe601;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe706;</i>
                            <div class="name">关闭</div>
                            <div class="code">&amp;#xe706;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe62c;</i>
                            <div class="name">退出</div>
                            <div class="code">&amp;#xe62c;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe651;</i>
                            <div class="name">下载</div>
                            <div class="code">&amp;#xe651;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe68f;</i>
                            <div class="name">主页</div>
                            <div class="code">&amp;#xe68f;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe690;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe690;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe667;</i>
                            <div class="name">错误</div>
                            <div class="code">&amp;#xe667;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe635;</i>
                            <div class="name">合同管理</div>
                            <div class="code">&amp;#xe635;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe691;</i>
                            <div class="name">文档</div>
                            <div class="code">&amp;#xe691;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe602;</i>
                            <div class="name">列表</div>
                            <div class="code">&amp;#xe602;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe717;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe717;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe718;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe718;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe668;</i>
                            <div class="name">短信</div>
                            <div class="code">&amp;#xe668;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6fc;</i>
                            <div class="name">刷新</div>
                            <div class="code">&amp;#xe6fc;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6cc;</i>
                            <div class="name">留言</div>
                            <div class="code">&amp;#xe6cc;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe603;</i>
                            <div class="name">退出</div>
                            <div class="code">&amp;#xe603;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe745;</i>
                            <div class="name">部门</div>
                            <div class="code">&amp;#xe745;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe692;</i>
                            <div class="name">下载</div>
                            <div class="code">&amp;#xe692;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe693;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe693;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe694;</i>
                            <div class="name">tags</div>
                            <div class="code">&amp;#xe694;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe719;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe719;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe73e;</i>
                            <div class="name">菜单</div>
                            <div class="code">&amp;#xe73e;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe71a;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe71a;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe681;</i>
                            <div class="name">系统日志</div>
                            <div class="code">&amp;#xe681;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe71b;</i>
                            <div class="name">新增</div>
                            <div class="code">&amp;#xe71b;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe695;</i>
                            <div class="name">修改</div>
                            <div class="code">&amp;#xe695;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe698;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe698;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6eb;</i>
                            <div class="name">接口管理</div>
                            <div class="code">&amp;#xe6eb;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe69b;</i>
                            <div class="name">回收站</div>
                            <div class="code">&amp;#xe69b;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe71d;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe71d;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe63a;</i>
                            <div class="name">密码</div>
                            <div class="code">&amp;#xe63a;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe746;</i>
                            <div class="name">邮件</div>
                            <div class="code">&amp;#xe746;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6af;</i>
                            <div class="name">参数</div>
                            <div class="code">&amp;#xe6af;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe747;</i>
                            <div class="name">参数</div>
                            <div class="code">&amp;#xe747;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6fe;</i>
                            <div class="name">刷新</div>
                            <div class="code">&amp;#xe6fe;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe71e;</i>
                            <div class="name">编辑</div>
                            <div class="code">&amp;#xe71e;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe720;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe720;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe749;</i>
                            <div class="name">权限管理</div>
                            <div class="code">&amp;#xe749;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe60f;</i>
                            <div class="name">系统设置</div>
                            <div class="code">&amp;#xe60f;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe721;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe721;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe669;</i>
                            <div class="name">logo水印</div>
                            <div class="code">&amp;#xe669;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe707;</i>
                            <div class="name">关闭</div>
                            <div class="code">&amp;#xe707;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6f7;</i>
                            <div class="name">支付宝</div>
                            <div class="code">&amp;#xe6f7;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe7e9;</i>
                            <div class="name">列表</div>
                            <div class="code">&amp;#xe7e9;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe722;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe722;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe74a;</i>
                            <div class="name">部门</div>
                            <div class="code">&amp;#xe74a;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe686;</i>
                            <div class="name">下载</div>
                            <div class="code">&amp;#xe686;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe74b;</i>
                            <div class="name">组件定义</div>
                            <div class="code">&amp;#xe74b;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe727;</i>
                            <div class="name">查询</div>
                            <div class="code">&amp;#xe727;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe77d;</i>
                            <div class="name">编辑</div>
                            <div class="code">&amp;#xe77d;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe755;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe755;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe69c;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe69c;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe723;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe723;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe724;</i>
                            <div class="name">编辑</div>
                            <div class="code">&amp;#xe724;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe725;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe725;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe7ac;</i>
                            <div class="name">站点内容</div>
                            <div class="code">&amp;#xe7ac;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe69d;</i>
                            <div class="name">文章</div>
                            <div class="code">&amp;#xe69d;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe7b9;</i>
                            <div class="name">查询</div>
                            <div class="code">&amp;#xe7b9;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe69f;</i>
                            <div class="name">栏目</div>
                            <div class="code">&amp;#xe69f;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe708;</i>
                            <div class="name">关闭</div>
                            <div class="code">&amp;#xe708;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe726;</i>
                            <div class="name">删除</div>
                            <div class="code">&amp;#xe726;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe74c;</i>
                            <div class="name">php</div>
                            <div class="code">&amp;#xe74c;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe66b;</i>
                            <div class="name">验证</div>
                            <div class="code">&amp;#xe66b;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6a0;</i>
                            <div class="name">自定义菜单</div>
                            <div class="code">&amp;#xe6a0;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe7ea;</i>
                            <div class="name">视频</div>
                            <div class="code">&amp;#xe7ea;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe682;</i>
                            <div class="name">图片</div>
                            <div class="code">&amp;#xe682;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe65f;</i>
                            <div class="name">主题风格</div>
                            <div class="code">&amp;#xe65f;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe74d;</i>
                            <div class="name">支付宝</div>
                            <div class="code">&amp;#xe74d;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6ab;</i>
                            <div class="name">日志</div>
                            <div class="code">&amp;#xe6ab;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe66c;</i>
                            <div class="name">字典</div>
                            <div class="code">&amp;#xe66c;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe674;</i>
                            <div class="name">短信</div>
                            <div class="code">&amp;#xe674;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe7eb;</i>
                            <div class="name">图标</div>
                            <div class="code">&amp;#xe7eb;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe74e;</i>
                            <div class="name">文档</div>
                            <div class="code">&amp;#xe74e;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6f1;</i>
                            <div class="name">审核</div>
                            <div class="code">&amp;#xe6f1;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe728;</i>
                            <div class="name">编辑</div>
                            <div class="code">&amp;#xe728;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe729;</i>
                            <div class="name">修改</div>
                            <div class="code">&amp;#xe729;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe72a;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe72a;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe680;</i>
                            <div class="name">个人信息</div>
                            <div class="code">&amp;#xe680;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe72b;</i>
                            <div class="name">添加</div>
                            <div class="code">&amp;#xe72b;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe74f;</i>
                            <div class="name">php</div>
                            <div class="code">&amp;#xe74f;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe655;</i>
                            <div class="name">个人信息</div>
                            <div class="code">&amp;#xe655;</div>
                        </li>

                        <li>
                            <i class="  larry-icon ">&#xe6f8;</i>
                            <div class="name">支付宝</div>
                            <div class="code">&amp;#xe6f8;</div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限:</label>
            <div class="layui-input-block">
                <input type="text" name="url"   lay-verify="required" placeholder="请输入权限!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否展开:</label>
            <div class="layui-input-block">
                <input type="radio" name="spread" value="true" title="展开">
                <input type="radio" name="spread" value="false" title="收缩" checked>
            </div>
        </div>
        <!--父级权限名称-->
        <div class="layui-form-item">
            <label class="layui-form-label">父级权限名:</label>
            <div class="layui-input-block">
                <input type="text"  value="${pName}" readonly="readonly"   autocomplete="off" class="layui-input">
                <input type="hidden"  value="${pid}" name="pid"/>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述:</label>
            <div class="layui-input-block">
                <textarea name="description" placeholder="请输入内容!" class="layui-textarea"></textarea>
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
<%--<script type="text/javascript" src="${path}/backstage/subgroup/js/font.js"></script>--%>
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
                    url:'/addPermission.action',
                    data:$('#addPermission').serialize(),
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

        //********************弹出图标层 start********************************
        $('#icon').focus(function(){
               $('#iconDiv').show();
        });
//        $('#icon').blur(function(){
//
//        });
        //********************弹出图标层 end********************************

        //获取选择的图标
        $('#icon-list li').click(function(){
            var $myDiv = $('#myDiv');
            $myDiv.remove();
           //获取i标签的文本值
            var txt = $(this).children('div:eq(1)').text();
            $('#icon').val(txt);
            $('#iconDiv').hide();
            //动态生成一个div
            console.log(txt);
//            var $i = $('<i class="layui-icon">&#xe60c;</i>');
            //var $i = $('<i class="layui-icon">&#xe715;</i>');
            //$i.html(txt);
            //$i.css('font-size','30px');
            var $div = '<div id="myDiv" class="icon-show"><i class="larry-icon">&#xe744;</i></div>';
            
            $('#showIcon').append($div);
        });
    });
</script>
</body>
</html>
