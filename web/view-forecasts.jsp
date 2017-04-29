<%-- 
    Document   : view-forecasts
    Created on : Apr 28, 2017, 8:56:09 PM
    Author     : Stephen Weber
--%>

<%@include file="header.jsp" %>

<div class="grid-100">
    <div id="forecastTable">
        <img src="styles/CLTSkyline.jpg">
        <p class="center">24 Hour forecast for Charlotte, North Carolina beginning at 12:00 AM EDT tomorrow </p>
        <table>
            <tr>
                <th>High Temperature (F)</th>
                <th>Low Temperature (F)</th>
                <th>Wind Speed (MPH)</th>
                <th>Sky Conditions</th>
                <th>Precipitation (Inches)</th>
                <c:if test="${sessionScope.theUser != null || sessionScope.theAdmin !=null}">
                    <th>Email A Friend</th>
                </c:if>
            </tr>
            <c:forEach items="${approvedForecasts}" var="f">
                <tr>
                    <td><c:out value="${f.highTemp}"/></td>
                    <td><c:out value="${f.lowTemp}"/></td>
                    <td><c:out value="${f.windSpeed}"/></td>
                    <td><c:out value="${f.skyConditions}"/></td>
                    <td><c:out value="${f.precip}"/></td>

                    <c:if test="${sessionScope.theUser != null || sessionScope.theAdmin !=null}">
                        <form action="forecast" method="post">
                            <input type="hidden" name="forecastID" value="<c:out value='${f.forecastID}'/>" />
                            <td>
                                <input type="email" name="toAddr" placeholder="Enter email address" required />
                                <button type="submit" name="action" value="email">Send</button>
                            </td>
                        </form>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<%@include file="footer.jsp" %>
