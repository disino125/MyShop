<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <c:if test="${isLogin==1}">
                        <b id="hello">Hallo！${user.USER_NAME}</b>
                    </c:if>
                    <c:if test="${isAdmin==1}">
                        <a href="manager/admin_index.jsp">backend system</a>
                    </c:if>
                    <c:if test="${isLogin!=1}">
                        <a href="login.jsp" id="login">anmelden</a><a href="register.jsp" id="reg">reg</a>
                    </c:if>
            </p>
                <form action="#" method="get" class="fl">
                    <input type="text" placeholder="Produkte suchen"/>
                    <input type="button"/>
                </form>
                <div class="btn fl clearfix"><a href="myInfo.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                    <c:if test="${isLogin==1}">
                        <a href="cart.jsp"><img src="img/gwc.png"/></a>
                    </c:if>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexSelect">Homepage</a></li>
            <c:forEach var="f" items="${fatherList}">
                <li><a href="selectProductList?fid=${f.CATE_ID}">${f.CATE_NAME}</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach var="s" items="${sonList}">
                                <c:if test="${s.CATE_PARENT_ID==f.CATE_ID}">
                                    <a href="selectProductList?sid=${s.CATE_ID}">${s.CATE_NAME}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
