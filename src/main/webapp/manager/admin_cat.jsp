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
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Homepage</a><span class="crumb-step">&gt;</span><span class="crumb-name">Kategorie</span></div>
    </div>
    <div class="result-wrap">
        <form name="myform" id="myform" method="post" action="admin_DoUserDel">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_toAddCate"><i class="icon-font"></i>Kategorie hinfügen</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="70%">
                    <tr>
                        <th>ID</th>
                        <th>Kategorie Name</th>
                        <th>bedienen</th>
                    </tr>
                    <c:forEach var="cate0" items="${cateList}">
                        <c:if test="${cate0.CATE_PARENT_ID==0}">
                            <tr>
                                <td>${cate0.CATE_ID}</td>
                                <td>|-${cate0.CATE_NAME}</td>
                                <td><a href="admin_toCateUpdate?id=${cate0.CATE_ID}">ändern</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:deleteCate('${cate0.CATE_NAME}','${cate0.CATE_ID}','${cate0.CATE_PARENT_ID}')">löschen</a></td>
                            </tr>
                            <c:forEach var="cate" items="${cateList}">
                                <c:if test="${cate.CATE_PARENT_ID==cate0.CATE_ID}">
                                    <tr>
                                        <td>${cate.CATE_ID}</td>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${cate.CATE_NAME}</td>
                                        <td><a href="admin_toCateUpdate?id=${cate.CATE_ID}">ändern</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:deleteCate('${cate.CATE_NAME}','${cate.CATE_ID}','${cate.CATE_PARENT_ID}')">löschen</a></td>
                                    </tr>

                                </c:if>
                            </c:forEach>

                        </c:if>
                    </c:forEach>
                    <script>
                        function deleteCate(name,id,parentId){
                            if(confirm("Wollen Sie diese Kategorie "+name+" löschen？")){
                                location.href="admin_doDeleteCate?id="+id+"&parentId="+parentId;
                            }

                        }
                    </script>
                </table>

            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
