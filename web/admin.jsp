<%-- 
    Document   : admin
    Created on : Apr 25, 2017, 8:54:06 PM
    Author     : Stephen Weber
--%>
<%@include file="header.jsp" %>

<div>
    <p>Forecasts submitted by users, please approve or reject.
        <br/>
       Please judge these forecasts based on physical plausibility and legitimacy
    </p>
    <table>
        <tr>
            <th>High Temperature (F)</th>
            <th>Low Temperature (F)</th>
            <th>Wind Speed (MPH)</th>
            <th>Sky Conditions</th>
            <th>Precipitation (Inches)</th>
        </tr>
        <c:forEach items="${submittedForecasts}" var="f">
            <tr>
                <td>${f.highTemp}</td>
                <td>${f.lowTemp}</td>
                <td>${f.windSpeed}</td>
                <td>${f.skyConditions}</td>
                <td>${f.precip}</td>
                <form action="forecast" method="post">
                    <input type="hidden" name="forecastID" value="${f.forecastID}" />
                    <td>
                        <button type="submit" name="action" value="approve">Approve</button>
                        <button type="submit" name="action" value="disapprove">Deny</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>  
</div>


<%@include file="footer.jsp" %>
