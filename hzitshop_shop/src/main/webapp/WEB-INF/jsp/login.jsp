
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>合众艾特营销系统登陆</title>
    <link rel="stylesheet" href="${path}/assets/login/css/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/assets/login/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${path}/assets/login/css/htmleaf-demo.css">
    <style type="text/css">
        .form-bg{
            background: #00b4ef;
        }
        .form-horizontal{
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .main-checkbox{
            float: left;
            width: 20px;
            height: 20px;
            background: #f8fcfa;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }
        /*checkbox 的默认效果*/
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        /*checkbox 勾选后的效果*/
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #1479d0;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .main-checkbox input[type=checkbox]{
            visibility: hidden;
        }
        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
            opacity: 1;
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style>
    <style>
        /*错误消息*/
        .error{
            color:red;
        }
    </style>
    <!--[if IE]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>合众艾特营销系统登陆!</h1>
        <h3>学IT选合众!</h3>
    </header>
    <div class="demo form-bg" style="padding: 20px 0;">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <form id="loginFrom" action="/login.action" method="post" class="form-horizontal">
                        <span class="heading">用户登录</span>
                        <p class="error" id="error">${error}</p>
                        <div class="form-group">
                            <input type="text" class="form-control" name="username" placeholder="请输入用户名!">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group help">
                            <input type="password" class="form-control" name="password" placeholder="请输入密码!">
                            <i class="fa fa-lock"></i>
                            <a href="#" id="forgetPwd" class="fa fa-question-circle"></a>
                        </div>
                        <div class="form-group">
                            <div class="main-checkbox">
                                <input type="checkbox" checked="checked" value="true" id="rememberMe" name="rememberMe"/>
                                <label for="rememberMe"></label>
                            </div>
                            <span class="text" style="color:red;">记住我!(勾选后7天内直接自动登陆系统)</span>
                            <button type="submit"  id="login" class="btn btn-default">登录</button><br/>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${path}/common/js/jquery-1.12.4.min.js"></script>
<script src="${path}/assets/jqueryvalidate/js/jquery.validate.min.js"></script>
<script src="${path}/assets/jqueryvalidate/js/messages_zh.min.js"></script>
<script src="${path}/assets/layer/layer.js"></script>
<script>
    //forgetPwd
    $(function(){
        $('#forgetPwd').click(function(){
           layer.alert('<p style="color:black;font-size: 23px;">忘记密码，请联系管理员<br/>邮箱:xianyaoji@hzitxx.com</p>',{shade:0});
        });
        $('#login').click(function(){
           $('#error').html('');
        });
        $('#loginFrom').validate({
            //表单验证规则
            rules:{
                username:{
                    required:true
                },
                password:{
                    required:true
                }
            },
            //表单验证消息
            messages:{
                username:'请输入用户名!',
                password:'请输入密码!'
            }
        })
    });
</script>
</body>
</html>