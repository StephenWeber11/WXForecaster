<%-- 
    Document   : view-forecasts
    Created on : Apr 28, 2017, 8:56:09 PM
    Author     : Stephen Weber
--%>

<%@include file="header.jsp" %>

<div>
    <p>24 Hour forecast for Charlotte, North Carolina beginning at 12:00 AM EDT tomorrow </p>
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
                <td>${f.highTemp}</td>
                <td>${f.lowTemp}</td>
                <td>${f.windSpeed}</td>
                <td>${f.skyConditions}</td>
                <td>${f.precip}</td>
                
                <form action="forecast" method="post">
                    <input type="hidden" name="forecastID" value="${f.forecastID}"/>
                    <input type="button" value="Email A Friend" class="emailForecast">
<!--                    <input type="email" name="toAddr" style="display: none !important;" required/>-->
<!--                    <button type="submit" name="action" value="SendEmail"></button>-->
                </form>
            </tr>
        </c:forEach>
    </table>  
</div>


<%@include file="footer.jsp" %>
