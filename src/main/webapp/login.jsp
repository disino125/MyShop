<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 21.02.2021
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>anmelden</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/function.js"></script>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="doLogin" method="post"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="username" value="" placeholder="username"></p>
        <p><input type="text" name="password" value="" placeholder="password"></p>
        <p><input class="code" type="text" name="codeValidate" value="" placeholder="validation"><img
                src="getCode" onclick="changeCode(this)"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.html">registrieren</a><a href="forget.html">password vergessen？</a></p></form>
</div>
</body>
</html>
