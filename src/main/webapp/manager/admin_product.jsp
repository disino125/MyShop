<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="admin_menu.jsp"  %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Homepage</a><span class="crumb-step">&gt;</span><span class="crumb-name">Produkte</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="admin_productSelect" method="get">
                <table class="search-tab">
                    <tr>
                        <th width="100">Stichwort:</th>
                        <td><input class="common-text" placeholder="Stichwort" name="keywords" value="" id="" type="text"></td>
                        <td><input class="btn btn-primary btn2" name="sub" value="suchen" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form name="myform" id="myform" method="post" action="#">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_toAddProduct"><i class="icon-font"></i>Produkte hinfügen</a>
                    <a id="batchDel" href="javascript:deleteMany('Wollen Sie den Produkt löschen？','myform')"><i class="icon-font"></i>Batch-Löschen</a>
                    <%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="50%">
                    <tr>
                        <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"  onclick="selectAll(this)"></th>
                        <th>ID</th>
                        <th>Photo</th>
                        <th>Name</th>
                        <th>Preiß</th>
                        <th>Vorrat</th>
                        <th>bedienen</th>
                    </tr>
                    <c:forEach var="p" items="${pList}">
                        <tr>
                            <td class="tc"><input name="id[]" value="${p.PRODUCT_ID}" type="checkbox"></td>
                            <td>${p.PRODUCT_ID}</td>
                            <td><img src="../img/products/${p.PRODUCT_IMG_NAME}" width="80" height="80"></td>
                            <td>${p.PRODUCT_NAME}</td>
                            <td>${p.PRODUCT_PRICE}</td>
                            <td>${p.PRODUCT_STOCK}</td>
                            <td>
                                <a class="link-update" href="toProductUpdate?pid=${p.PRODUCT_ID}&cp=${currentPage}">ändern</a>
                                <a class="link-del" href="javascript:Delete('Wollen Sie den Product ${p.PRODUCT_NAME} löschen?',
                                'admin_doProductDel?pid=${p.PRODUCT_ID}&cp=${currentPage}')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;löschen</a>

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
                    insges. ${totalCount} Ergebnisse，aktuell ${currentPage}/${totalPages} Seite
                    <a href="admin_productSelect?cp=1${searchParam}">erste</a>
                    <a href="admin_productSelect?cp=${currentPage-1<1?1:currentPage-1}${searchParam}">letzte</a>
                    <a href="admin_productSelect?cp=${currentPage+1>totalPages?totalPages:currentPage+1}${searchParam}">nächste</a>
                    <a href="admin_productSelect?cp=${totalPages}${searchParam}">ende</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
