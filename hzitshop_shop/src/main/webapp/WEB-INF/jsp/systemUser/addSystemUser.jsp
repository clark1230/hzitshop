<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GIGABYTE
  Date: 2017/9/17
  Time: 0:04
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
<body>
<div class="larry-grid larry-wrapper">
    <form id="addSystemUser" class="layui-form" action="/addSystemUser.action" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="userName"   lay-verify="required" placeholder="请输入用户名!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄:</label>
            <div class="layui-input-block">
                <input type="number" name="age"    placeholder="请输入年龄!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="gender" value="男" title="男">
                <input type="radio" name="gender" value="女" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">qq:</label>
            <div class="layui-input-block">
                <input type="number" name="qq"    placeholder="请输入qq!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱:</label>
            <div class="layui-input-block">
                <input type="text" name="email" required  lay-verify="required" placeholder="请输入邮箱!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址:</label>
            <div class="layui-input-block">
                <input type="text" name="address"   placeholder="请输入地址!" autocomplete="off" class="layui-input">
            </div>
        </div>
        <!--是否禁用-->
        <div class="layui-form-item">
            <label class="layui-form-label">是否禁用:</label>
            <div class="layui-input-block">
                <input type="radio" name="isLock" value="0" title="禁用">
                <input type="radio" name="isLock" value="1" title="启用" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司:</label>
            <div class="layui-input-block">
                <select name="company" lay-filter="company">
                    <option value=""></option>
                    <c:forEach items="${orgCompany}" var="org">
                        <option value="${org.name}_${org.orgId}">${org.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门:</label>
            <div class="layui-input-block">
                <select name="dept" id="dept"  lay-filter="dept">
                    <option value=""></option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">岗位:</label>
            <div class="layui-input-block">
                <select name="jobId" id="job" lay-filter="job">
                    <option value=""></option>

                </select>
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
<script>
    $(function(){
       $('#goback').click(function(){
          history.go(-1);
       });
       

        layui.use('form', function(){
            var form = layui.form;
            
            //监听下拉列表事件
            form.on('select(company)',function(data){
                //截取数据
                var orgParentId = data.value.substring(data.value.indexOf("_")+1);
                //异步获取部门信息
                getOrg(orgParentId,$('#dept'));
            });
            form.on('select(dept)', function(data){
                var  value= data.value;
                if(value ==''){
                    layer.msg('请先选择公司!',{icon:3});
                }else{
                    var orgParentId = value.substring(value.indexOf("_")+1);
                    getOrg(orgParentId,$('#job'))
                }
            });
            form.on('select(job)',function(data){
               if(data.value ==''){
                   layer.msg('请先选择部门!',{icon:3});
               }else{

               }
            });

            function getOrg(orgId,selctor){
                $.get('/orgTypeAjax.action?orgParentId='+orgId,function(resp){
                    //拼接标签
                    selctor.find('option:gt(0)').remove();//删除生成的标签
                    for(var i=0;i<resp.length;i++){
                        var $option = $('<option value="'+resp[i].name+'_'+resp[i].orgId+'">'+resp[i].name+'</option>');
                        selctor.append($option);
                    }
                    form.render(); //重新渲染
                });
            }
            //监听提交
            form.on('submit(add)', function(data){
                //layer.msg(JSON.stringify(data.field));
                $.ajax({
                    method:'post',
                    url:'/addSystemUser.action',
                    data:$('#addSystemUser').serialize(),
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
