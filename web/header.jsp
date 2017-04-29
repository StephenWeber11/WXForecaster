<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UNCC WxForecaster</title>
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="stylesheet" href="styles/unsemantic-grid-responsive.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </head>
    <body>
        <div id="header">
            <nav class="grid-container">
                <div class="grid-30">
                    <div id="headerName">
                        <div id="wxName">
                        <c:choose>
                            <c:when test="${sessionScope.theUser != null || sessionScope.theAdmin != null}">
                                <p><a href="forecast">UNCC WxForecaster</a></p>
                            </c:when>
                            <c:otherwise>
                                <p><a href="home.jsp">UNCC WxForecaster</a></p>
                            </c:otherwise>
                        </c:choose>
                        </div>
                    </div>
                </div>
                <div class="grid-70">
                    <div id="siteNav">
                        <ul>
                            <li><a href="user?action=about">About Us</a></li>
                            <li><a href="user?action=how">Forecasting 101</a></li>
                            <li><a href="forecast?action=view-forecasts">View Forecasts</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.theUser == null && sessionScope.theAdmin == null}">
                                    <li><a href="home.jsp#loginContainer">Login</a></li>
                                </c:when>   
                                <c:otherwise>
                                    <li><a href="forecast.jsp">Forecast</a></li>
                                    <li><a href="user?action=logout">Log Out</a></li>
                                </c:otherwise>
                            </c:choose>
                            <c:if test="${sessionScope.theAdmin != null}">
                                <li><a href="forecast?action=admin">Admin</a></li>  
                            </c:if>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="grid-container">

