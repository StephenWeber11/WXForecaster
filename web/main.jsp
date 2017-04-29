<%-- 
    Document   : main
    Created on : Apr 25, 2017, 8:56:22 PM
    Author     : Stephen Weber
--%>

<%@include file="/header.jsp" %>
<div class="grid-100">
    <div id="mainTop">
        <c:choose>
            <c:when test="${sessionScope.theAdmin != null}">
               <h2 class="center">Welcome, <span>${sessionScope.theAdmin.firstName}</span></h2>
            </c:when>
            <c:otherwise>
                <h2 class="center">Welcome, <span>${sessionScope.theUser.firstName}</span></h2>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="grid-50">
        <h3 class='center'>Forecasting Instructions</h3>
        <br/>
        <p> In order to submit a reliable and accurate forecast, please examine all weather data at your disposal on this website.
                   The model guidance MOS on the forecast page should be sufficient to get forecasters of all skill levels started, but always be mindful of the radar below.
                   Model data does not always paint a clear picture and as such, you should be on the lookout for anything visual that is concerning.
            <br/><br/>
            To begin a forecast, click on the <a href="/forecast.jsp">Forecast</a> button at the top right of this page. Once there, use the knowledge you have gained from the 
            <a href="/forecasting101.jsp">Forecasting 101</a> page to make your best forecast! Once submitted, the admin will either approve/deny and you will recieve an email regarding
            their decision!
            <br/><br/>
            Lastly, be sure to continue to consult the <a href="/forecasting101.jsp">Forecasting 101</a> page to learn how to better forecast the weather!
        </p>
        
    </div>
    <div class="grid-50">
        <h3 class='center'>Tips</h3>
        <br/>
        <p>Since we are now rolling into the summer season, it's time to start thinking about severe weather!
            Being downslope of the Appalachian mountains aids in the development of severe storms as drier air aloft
            is forced to mix with the warm, moist air at the surface. This creates a lot of instability and can trigger some
            exhilarating thunderstorms!
            <br/><br/>
            When you see a high temperature and a high dew point, you know the day will be humid. So when forecasting, check the probability
            or precipitation (POP). If that's high, you have a good chance at some thunderstorms!
        </p>
    </div>
</div>

<div id="radar">
    <iframe src="http://weather.rap.ucar.edu/radar/displayRad.php?icao=KUSA&prod=bref1&bkgr=gray&endDate=20170428&endTime=-1&duration=6" width="1220px" height="1000px"></iframe>
</div>
<%@include file="/footer.jsp" %>
