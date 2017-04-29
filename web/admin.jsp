<%-- 
    Document   : admin
    Created on : Apr 25, 2017, 8:54:06 PM
    Author     : Stephen Weber
--%>
<%@include file="header.jsp" %>

<div>
    <p>TEST</p>
    <c:forEach items="${submittedForecasts}" var="forecast">
        <tr>
            <td>${forecast.highTemp}</td>
        </tr>
    </c:forEach>
</div>


<%@include file="footer.jsp" %>
