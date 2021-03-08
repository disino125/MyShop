<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"  %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Homepage</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_cat.jsp">Produkte</a><span class="crumb-step">&gt;</span><span>Produkte hinfügen</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_doAddProduct" method="post" enctype="multipart/form-data" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>Kategorie：</th>
                        <td>
                            <select class="common-text required" name="parentId">
                                <c:forEach var="f" items="${fatherList}">
                                    <option value="${f.CATE_ID}" disabled="disabled">|-${f.CATE_NAME}</option>
                                    <c:forEach var="s" items="${sonList}">
                                        <c:if test="${s.CATE_PARENT_ID==f.CATE_ID}">
                                            <option value="${f.CATE_ID}-${s.CATE_ID}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${s.CATE_NAME}</option>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>


                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Name：</th>
                        <td>
                            <input class="common-text required" id="proName" name="proName" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Photo：</th>
                        <td>
                            <input class="common-text required" id="proImg" name="proImg" size="50" value="" type="file">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Preiß：</th>
                        <td>
                            <input class="common-text required" id="price" name="price" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Beschreibung：</th>
                        <td>
                            <input class="common-text required" id="description" name="description" size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>Vorrat：</th>
                        <td>
                            <input class="common-text required" id="stock" name="stock" size="50" value="" type="text">
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
