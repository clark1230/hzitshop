<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>组织管理</title>
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
    <link rel="stylesheet" type="text/css" href="${path}/assets/ztree/css/zTreeStyle/zTreeStyle.css" media="all">
    <style>
        .disabled{
            background-color:lightgray;
        }

    </style>
</head>
<body>
<div class="layui-fluid larry-wrapper">
    <div class="layui-row  animated bounceIn">
        <div class="layui-col-lg12 layui-col-md12 layui-col-sm12 layui-col-xs12">
            <%--<div class="layui-btn-group larry-group" >--%>
            <div class="" id="larry_group">
                <div class="layui-inline">
                    <button class="layui-btn"  data-type="add"><i class="layui-icon">&#xe61f;</i><cite>增加</cite></button>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-warm"  data-type="edit"><i class="layui-icon">&#xe642;</i><cite>修改</cite></button>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-normal disabled" id="expand"  data-type="expand" disabled="disabled" ><i class="layui-icon" >&#xe61a;</i><cite>展开</cite></button>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layui-btn-normal" id="close"  data-type="close"><i class="layui-icon">&#xe619;</i><cite>收缩</cite></button>
                </div>
                <div class="layui-input-inline" style="display: inline-block;">
                    <input type="text" name="search" value="" id="search_input" placeholder="请输入搜索内容!" class="layui-input">
                </div>
                <a class="layui-btn search_btn layui-btn-normal" data-type="getSelect"><i class="layui-icon">&#xe615;</i>查询</a>
            </div>
            <%--</div>--%>

        </div>

        <div class="layui-col-lg2 layui-col-md2 layui-col-sm4 layui-col-xs5" style="background-color:#F2F2F2;margin-top:10px;">
            <ul id="tree" class="ztree">

            </ul>
        </div>
        <div class="layui-col-lg10 layui-col-md10 layui-col-sm8 layui-col-xs7">
            <table id="orgTables" ></table>
        </div>
    </div>
</div>
<!--自定义图标模板-->
<script type="text/html" id="iconTpl">
   <i class="larry-icon" style="color:#1E9FFF;font-size: 25px;">{{d.icon}}</i>
</script>
<script type="text/html" id="spreadTpl">
    {{#  if(d.spread == 'true'){ }}
        <span class="layui-badge layui-bg-blue" >展开</span>
    {{#  } else { }}
        <span class="layui-badge layui-bg-orange">收缩</span>
    {{#  } }}
</script>

<script type="text/html" id="levelTpl">
    {{#  if(d.level == 1){ }}
        <span class="layui-badge layui-bg-orange">顶级菜单</span>
    {{#  } }}
    {{#  if(d.level == 2){ }}
        <span class="layui-badge layui-bg-blur">一级菜单</span>
    {{#  } }}
    {{#  if(d.level == 3){ }}
        <span class="layui-badge layui-bg-green">二级菜单</span>
    {{#  } }}
    {{#  if(d.level == 4){ }}
        <span class="layui-badge"  style="background-color: purple;">三级菜单</span>
    {{#  } }}
    {{#  if(d.level == 5){ }}
        <span class="layui-badge layui-bg-gray">按&nbsp;&nbsp;钮</span>
    {{#  } }}
</script>
    <!-- 加载js文件 -->
<script type="text/javascript" src="${path}/common/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path}/assets/ztree/jquery.ztree.all.js"></script>
<script type="text/javascript" src="${path}/common/frame/layui/layui.js"></script>
<script type="text/javascript" src="${path}/backstage/js/common.js"></script>
<script type="text/javascript" src="${path}/assets/layer/layer.js"></script>
<script type="text/javascript" src="${path}/assets/js/hzitshop/permission/permission.js"></script>
</body>
</html>

