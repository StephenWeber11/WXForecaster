<%-- 
    Document   : admin
    Created on : Apr 25, 2017, 8:54:06 PM
    Author     : Stephen Weber
--%>
<%@include file="header.jsp" %>

<div class="grid-100">
    <div id="forecastTable" class="center">
        <p>Forecasts submitted by users, please <strong>approve</strong> or <strong>reject</strong>.
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
                    <td><c:out value="${f.highTemp}"/></td>
                    <td><c:out value="${f.lowTemp}"/></td>
                    <td><c:out value="${f.windSpeed}"/></td>
                    <td><c:out value="${f.skyConditions}"/></td>
                    <td><c:out value="${f.precip}"/></td>
                    <form action="forecast" method="post">
                        <input type="hidden" name="forecastID" value="<c:out value='${f.forecastID}'/>" />
                        <td>
                            <button type="submit" name="action" value="approve">Approve</button>
                            <button type="submit" name="action" value="disapprove">Deny</button>
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<%@include file="footer.jsp" %>
