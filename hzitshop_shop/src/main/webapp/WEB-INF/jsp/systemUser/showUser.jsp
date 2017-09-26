<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String  path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
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
                    <span class="tit">个人信息</span>
                </div>
                <div class="larry-body-content clearfix">
                    <form class="layui-form" action="" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-block">
                                <input type="text" name="userName"  autocomplete="off"  class="layui-input layui-disabled" value="${systemUser.userName}" disabled="disabled" >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">所属角色</label>
                            <div class="layui-input-block">
                                <input type="text" name="username"  autocomplete="off" class="layui-input layui-disabled" value="超级管理员" disabled="disabled">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">年龄</label>
                            <div class="layui-input-block">
                                <input type="text" name="age"  value="${systemUser.age}" autocomplete="off" class="layui-input" placeholder="年龄">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                <input type="radio" name="gender" value="男" title="男" <c:if test="${systemUser.gender =='男'}">checked</c:if>/>
                                <div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>男</span></div>
                                <input type="radio" name="gender" value="女" title="女" <c:if test="${systemUser.gender =='女'}">checked</c:if>/>
                                <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>女</span></div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">qq</label>
                            <div class="layui-input-block">
                                <input type="text" name="qq"  value="${systemUser.qq}" autocomplete="off" class="layui-input" placeholder="请输入QQ号!">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">地址</label>
                            <div class="layui-input-block">
                                <input type="text" name="address"  value="${systemUser.address}" autocomplete="off" class="layui-input" placeholder="请输入QQ号!">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" name="email"  value="${systemUser.email}" autocomplete="off" class="layui-input" placeholder="请输入邮箱!">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">公司</label>
                            <div class="layui-input-block">
                                <input type="text" name="company"  value="${systemUser.company}" autocomplete="off" class="layui-input" placeholder="公司">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">部门</label>
                            <div class="layui-input-block">
                                <input type="text" name="dept"  value="${systemUser.dept}" autocomplete="off" class="layui-input" placeholder="部门">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">岗位</label>
                            <div class="layui-input-block">
                                <input type="text" name="jobId"  value="${systemUser.jobId}" autocomplete="off" class="layui-input" placeholder="岗位">
                            </div>
                        </div>
                        
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
          
</script>
</body>
</html>
