<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>reg</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    
    <style>
    	.reg p .error {
    		display:inline-block;
    		border:1px solid #ff855a;
    		background-color:#ffe8e0;
    		height:25px;
    		line-height:25px;
    		padding:0px 20px;
    		margin-left:20px;
    	}
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <h1 style="padding:0px;magin:0px;font-size:30px;background:#3344AA;text-align:center;line-height:60px;color:#FFFFFF">Registrieren</h1>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="username"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="name"><span></span></p>
        <p><input type="text" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="password"><span></span></p>
         <p><input type="text" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="password wiederholen"><span></span></p>
        <p>
        	<input style="width:15px;height:15px" type="radio" name="sex" value="T" checked="checked">Mann
        	<input style="width:15px;height:15px" type="radio" name="sex" value="F" >Frau
        	</p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="Geburtstag"><span></span></p>
         <p><input type="text" name="email" value="" placeholder="Email"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="MobilNr"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="Adresse"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
        <img height="25" src="getcode" alt="ein anderes photo" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="reg"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>Hast du schon ein Konto?</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>