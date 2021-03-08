<%--
  Created by IntelliJ IDEA.
  User: Benutzer2
  Date: 14.02.2021
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Backend System Template</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="admin_index.jsp" class="navbar-brand">Backend System</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">Homepage</a></li>
                <li><a href="/MyShop/indexSelect" target="_blank">Website-Homepage</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">Admin:${user.USER_NAME}</a></li>
                <li><a href="#">Password ändern</a></li>
                <li><a href="/MyShop/doLogout">abmelden</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>Menü</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>Verwaltung</a>
                    <ul class="sub-menu">
                        <li><a href="admin_DoUserSelect"><i class="icon-font">&#xe008;</i>Benutzer</a></li>
                        <li><a href="admin_cateSelect"><i class="icon-font">&#xe005;</i>Kategorie</a></li>
                        <li><a href="admin_productSelect"><i class="icon-font">&#xe006;</i>Produkte</a></li>
                        <li><a href="admin_oder.jsp"><i class="icon-font">&#xe004;</i>Bestellung</a></li>
                        <li><a href="admin_message.jsp"><i class="icon-font">&#xe012;</i>Kommentar</a></li>
                        <li><a href="admin_news.jsp"><i class="icon-font">&#xe052;</i>Presse</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>数据备份</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>数据还原</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
