<%-- 
    Document   : view-forecasts
    Created on : Apr 28, 2017, 8:56:09 PM
    Author     : Stephen Weber
--%>

<%@include file="header.jsp" %>

<div>
    <p class="center">24 Hour forecast for Charlotte, North Carolina beginning at 12:00 AM EDT tomorrow </p>
    <table>
        <tr>
            <th>High Temperature (F)</th>
            <th>Low Temperature (F)</th>
            <th>Wind Speed (MPH)</th>
            <th>Sky Conditions</th>
            <th>Precipitation (Inches)</th>
        </tr>
        <c:forEach items="${approvedForecasts}" var="f">
            <tr>
                <td><c:out value="${f.highTemp}"/></td>
                <td><c:out value="${f.lowTemp}"/></td>
                <td><c:out value="${f.windSpeed}"/></td>
                <td><c:out value="${f.skyConditions}"/></td>
                <td><c:out value="${f.precip}"/></td>
                
                <form action="forecast" method="post">
                    <input type="hidden" name="forecastID" value="${f.forecastID}"/>
                    <td>
                        <input type="email" name="email" placeholder="Enter email address" required />
                        <input type="button" value="Email A Friend" class="emailForecast">
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>  
</div>


<%@include file="footer.jsp" %>
