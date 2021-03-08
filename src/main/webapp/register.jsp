<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 18.02.2021
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    <script src="js/jquery-1.12.4.min.js"></script>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="doRegister" method="post" onsubmit="return checkForm(this)"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <h5 style="padding: 0px;margin: 0px;font-size: 30px;text-align: left">注册</h5>
        <p><input type="text" name="username" onfocus="focusItem(this)" onblur="checkItem(this)" value="" placeholder="请输入用户名"><span class="error"></span></p>
        <p><input type="text" name="name" value="" onfocus="focusItem(this)" onblur="checkItem(this)" placeholder="请输入姓名"><span class="error"></span></p>
        <p><input type="text" id="psw" name="password" onfocus="focusItem(this)" onblur="checkItem(this)" value="" placeholder="请输入密码"><span class="error"></span></p>
        <p><input type="text" name="rePassword" value="" onfocus="focusItem(this)" onblur="checkItem(this)" placeholder="请确认密码"><span class="error"></span></p>
        <p>
            <input style="width: 30px;height: 15px" type="radio" name="gender" value="T" checked="checked">男
            <input style="width: 30px;height: 15px" type="radio" name="gender" value="F">女
        </p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this),focusItem(this)" onblur="checkItem(this)" placeholder="请输入出生日期"><span class="error"></span></p>
        <p><input type="text" name="email" value="" onfocus="focusItem(this)" onblur="checkItem(this)" placeholder="请输入邮箱"><span class="error"></span></p>
        <p><input type="text" name="mobil" value="" onfocus="focusItem(this)" onblur="checkItem(this)" placeholder="请确认手机号码"><span class="error"></span></p>
        <p><input type="text" name="address" value="" onfocus="focusItem(this)" onblur="checkItem(this)" placeholder="请输入送货地址"><span class="error"></span></p>
        <p><input class="code" type="text" name="codeValidate" value="" onfocus="focusItem(this)" onblur="checkItem(this)" placeholder="验证码"><img
                src="getCode" onclick="changeCode(this)"><span id="code" class="error"></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#"><使用条款和隐私策略></a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
</div>
</body>
</html>
