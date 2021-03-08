<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 24.02.2021
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"  %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Homepage</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_cat.jsp">Kategorie</a><span class="crumb-step">&gt;</span><span>Kategorie hinfügen</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_doAddCate" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>Root Kategorie：</th>
                        <td>
                            <select class="common-text required" name="parent">
                                <option value="0" selected="selected">Root Kategorie</option>
                                <c:forEach var="cate" items="${cateList}">
                                    <c:if test="${cate.CATE_PARENT_ID==0}">
                                        <option value="${cate.CATE_ID}">${cate.CATE_NAME}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Kategorie-Name：</th>
                        <td>
                            <input class="common-text required" id="cateName" name="cateName" size="50" value="" type="text">
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
