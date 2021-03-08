<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 14.02.2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"  %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">Benutzerverwaltung</a><span class="crumb-step">&gt;</span><span>Benutzer hinfügen</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admin_DoAddUser" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>Benutzername：</th>
                            <td>
                                <input class="common-text required" id="username" name="username" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>Name：</th>
                            <td>
                                <input class="common-text required" id="name" name="name" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>Kennwort：</th>
                            <td>
                                <input class="common-text required" id="psw" name="password" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>Kennwort wiederholen：</th>
                            <td>
                                <input class="common-text required" id="rePassword" name="rePassword" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th>Geschlecht：</th>
                            <td>
                                <input type="radio" value="T" name="gender" checked="checked">Mann
                                <input type="radio" value="F" name="gender">Frau
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>Geburtsdatum：</th>
                            <td>
                                <input class="common-text required" id="birthday" name="birthday" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>Email：</th>
                            <td>
                                <input class="common-text required" id="email" name="email" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>HandyNr：</th>
                            <td>
                                <input class="common-text required" id="mobil" name="mobil" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>Addresse：</th>
                            <td>
                                <input class="common-text required" id="address" name="address" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="senden" type="submit">
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