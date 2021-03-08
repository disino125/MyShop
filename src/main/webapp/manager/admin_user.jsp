<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 14.02.2021
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="admin_menu.jsp"  %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Homepage</a><span class="crumb-step">&gt;</span><span class="crumb-name">Benutzer</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="admin_DoUserSelect" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="100">Stichwort:</th>
                            <td><input class="common-text" placeholder="Stichwort" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="suchen" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post" action="admin_DoUserDel">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_addUser.jsp"><i class="icon-font"></i>Benutzer hinfügen</a>
                        <a id="batchDel" href="javascript:deleteMany('Wollen Sie den Benuter löschen？','myform')"><i class="icon-font"></i>Batch-Löschung</a>
<%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"  onclick="selectAll(this)"></th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Geschlecht</th>
                            <th>Email</th>
                            <th>Handy</th>
                            <th>bedienen</th>
                        </tr>
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td class="tc"><input name="id[]" value="${user.USER_ID}" type="checkbox"></td>
                                <td>${user.USER_ID}</td>
                                <td>${user.USER_NAME}</td>
                                <td>${user.USER_GENDER=='T'?'Mann':'Frau'}</td>
                                <td>${user.USER_EMAIL}</td>
                                <td>${user.USER_MOBIL}</td>
                                <td>
                                    <a class="link-update" href="admin_toUserUpdate?id=${user.USER_ID}&cp=${currentPage}">ändern</a>
                                    <c:if test="${user.USER_STATUS==1}">
                                        <a class="link-del" href="javascript:Delete('Wollen Sie den Benutzer ${user.USER_NAME} löschen？',
                                        'admin_DoUserDel?id=${user.USER_ID}&cp=${currentPage}')">löschen</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        <script>
                            function Delete(msg,url){
                                if(confirm(msg)){
                                    location.href=url;
                                }
                            }

                            function selectAll(o) {
                                var a = document.getElementsByName('id[]');
                                for(var i=0;i<a.length;i++){
                                    a[i].checked=o.checked;
                                }
                            }

                            function deleteMany(msg,formName) {
                                if(confirm(msg)){
                                    var form = document.getElementById(formName);
                                    form.submit();
                                }
                            }
                        </script>
                    </table>
                    <div class="list-page">
                        total ${totalUsers} Ergebnisse，aktuell ${currentPage}/${totalPages} Seite
                        <a href="admin_DoUserSelect?cp=1${searchParam}">erste</a>
                        <a href="admin_DoUserSelect?cp=${currentPage-1<1?1:currentPage-1}${searchParam}">letzte</a>
                        <a href="admin_DoUserSelect?cp=${currentPage+1>totalPages?totalPages:currentPage+1}${searchParam}">nächste</a>
                        <a href="admin_DoUserSelect?cp=${totalPages}${searchParam}">ende</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
