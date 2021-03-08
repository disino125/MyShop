<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 14.02.2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="admin_menu.jsp"  %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list">
            <i class="icon-font"></i>
            <a href="admin_index.jsp">Homepage</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="admin_DoUserSelect">User</a>
            <span class="crumb-step">&gt;</span><span>Ändern</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_DoUserUpdate" method="post" id="myform" name="myform">
                <input type="hidden" name="cp" value="${cp}">
                <input type="hidden" name="userStatus" value="${user.USER_STATUS}">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>Username：</th>
                        <td>
                            <input class="common-text required" id="username" name="username" size="50" value="${user.USER_ID}" type="text" readonly="true">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Name：</th>
                        <td>
                            <input class="common-text required" id="name" name="name" size="50" value="${user.USER_NAME}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Password：</th>
                        <td>
                            <input class="common-text required" id="psw" name="password" size="50" value="${user.USER_PASSWORD}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th>Geschlecht：</th>
                        <td>
                            <input type="radio" value="T" name="gender" ${user.USER_GENDER=='T'?"checked":""}>Mann
                            <input type="radio" value="F" name="gender" ${user.USER_GENDER=='F'?"checked":""}>Frau
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Geburtstag：</th>
                        <td>
                            <input class="common-text required" id="birthday" name="birthday" size="50" value="${user.USER_BIRTHDAY}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Email：</th>
                        <td>
                            <input class="common-text required" id="email" name="email" size="50" value="${user.USER_EMAIL}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>HandyNr：</th>
                        <td>
                            <input class="common-text required" id="mobil" name="mobil" size="50" value="${user.USER_MOBIL}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Adresse：</th>
                        <td>
                            <input class="common-text required" id="address" name="address" size="50" value="${user.USER_ADDRESS}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="ändern" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="zurück" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>