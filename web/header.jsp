<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WxForecaster</title>
        <link rel="stylesheet" href="styles/styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </head>
    <body>
        <div id="header">
                <nav id="header_menu">
                <ul class="left" >
                    <c:choose>
                        <c:when test="${sessionScope.theUser != null || sessionScope.theAdmin != null}">
                            <li><a href="forecast">WxForecaster</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="home.jsp">WxForecaster</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <ul class="right">
                    <c:choose>
                        <c:when test="${sessionScope.theUser != null}">
                            <li>Hello, <span>${theUser.firstName}</span></li>
                        </c:when>
                        <c:when test="${sessionScope.theAdmin != null}">
                        <li>Hello, <span>${theAdmin.firstName}</span></li>
                        </c:when>
                    </c:choose>
                    <li><a href="user?action=about">About Us</a></li>
                    <li><a href="user?action=how">Forecasting 101</a></li>
                    <c:choose>
                        <c:when test="${sessionScope.theUser == null && sessionScope.theAdmin == null}">
                            <li><a href="login.jsp">Login</a></li>
                        </c:when>   
                        <c:otherwise>
                            <li><a href="user?action=logout">Log Out</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
        <div class="grid-container">

