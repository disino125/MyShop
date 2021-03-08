<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『Disino』Backend System</title>
    <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>Backend System</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="adminLogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">Username：</label>
                        <input type="text" name="username" value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">Kennwort：</label>
                        <input type="password" name="password" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="anmelden" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="/MyShop/index.jsp" target="_blank">homepage zurück</a> &copy; 2014 Powered by 更多模板：<a href="http://www.lmonkey.com/" target="_blank">学习猿地</a></p>
</div>
</body>
</html>
