<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/9/17
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
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
</head>
</head>
<body>
<div class="larry-grid larry-wrapper">
    <form id="editSystemUser" class="layui-form" action="/editSystemUser.action" method="post">
        <input type="hidden" value="${systemUser.userId}" name="userId"/>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="userName" value="${systemUser.userName}"   lay-verify="required" placeholder="请输入用户名!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄:</label>
            <div class="layui-input-block">
                <input type="number" name="age" value="${systemUser.age}"   placeholder="请输入年龄!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="gender" value="男" title="男" <c:if test="${systemUser.gender == '男'}">checked</c:if>/>
                <input type="radio" name="gender" value="女" title="女" <c:if test="${systemUser.gender == '女'}">checked</c:if>/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">qq:</label>
            <div class="layui-input-block">
                <input type="number" name="qq" value="${systemUser.qq}"   placeholder="请输入qq!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱:</label>
            <div class="layui-input-block">
                <input type="text" name="email" value="${systemUser.email}" required  lay-verify="required" placeholder="请输入邮箱!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址:</label>
            <div class="layui-input-block">
                <input type="text" name="address"  value="${systemUser.address}"  placeholder="请输入地址!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <!--是否禁用-->
        <div class="layui-form-item">
            <label class="layui-form-label">是否禁用:</label>
            <div class="layui-input-block">
                <input type="radio" name="isLock" value="0" title="禁用" <c:if test="${systemUser.isLock == '0'}">checked</c:if>/>
                <input type="radio" name="isLock" value="1" title="启用" <c:if test="${systemUser.isLock == '1'}">checked</c:if>/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司:</label>
            <div class="layui-input-block">
                <select name="company" lay-filter="company">
                    <option value=""></option>
                    <c:forEach items="${orgCompany}" var="com">
                        <option value="${com.orgId}" <c:if test="${com.orgId == systemUser.company}">selected</c:if>>${com.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门:</label>
            <div class="layui-input-block">
                <select name="dept" id="dept" lay-filter="dept">
                    <option value=""></option>
                    <c:forEach items="${orgDept}" var="dept">
                        <option value="${dept.orgId}" <c:if test="${dept.orgId == systemUser.dept}">selected</c:if>>${dept.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">岗位:</label>
            <div class="layui-input-block">
                <select name="jobId" id="job" lay-filter="job">
                    <option value=""></option>
                    <c:forEach items="${orgJob}" var="job">
                        <option value="${job.orgId}" <c:if test="${job.orgId == systemUser.jobId}">selected</c:if>>${job.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn"lay-submit lay-filter="edit">保 存</button>
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
<script>
    $(function(){
        $('#goback').click(function(){
            history.go(-1);
        });

        layui.use('form', function(){
            var form = layui.form;
            //监听提交
            //监听下拉列表事件
            form.on('select(company)',function(data){
                //截取数据
                var orgParentId = data.value;
                //异步获取部门信息
                getOrg(orgParentId,$('#dept'));
                $('#job').find('option:gt(0)').remove();
            });
            form.on('select(dept)', function(data){
                var  value= data.value;
                if(value ==''){
                    layer.msg('请先选择公司!',{icon:3});
                }else{
                    var orgParentId = value;
                    getOrg(orgParentId,$('#job'))
                }
            });
            form.on('select(job)',function(data){
                if(data.value ==''){
                    layer.msg('请先选择部门!',{icon:3});
                }
            });
            function getOrg(orgId,selctor){

                $.get('/orgTypeAjax.action?orgParentId='+orgId,function(resp){
                    //拼接标签
                    selctor.find('option:gt(0)').remove();//删除生成的标签
                    for(var i=0;i<resp.length;i++){
                        var $option = $('<option value="'+resp[i].orgId+'">'+resp[i].name+'</option>');
                        selctor.append($option);
                    }
                    form.render(); //重新渲染
                });
            }
            form.on('submit(edit)', function(data){
                //layer.msg(JSON.stringify(data.field));
                $.ajax({
                    method:'post',
                    url:'/editSystemUser.action',
                    data:$('#editSystemUser').serialize(),
                    success:function(resp){
                        if(resp.code === 200){
                            layer.msg(resp.msg,{icon:1});
                            setTimeout(function(){
                                history.go(-1);
                            },1500);
                        }else{
                            layer.msg(resp.msg,{icon:2});
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
