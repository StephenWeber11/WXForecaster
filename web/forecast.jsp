<%-- 
    Document   : forecast
    Created on : Apr 25, 2017, 7:03:09 PM
    Author     : Stephen
--%>
<%@include file="/header.jsp" %>
<div>
    <p>${msg}</p>
    <form action="forecast" method="post">
        <input type="hidden" name="action" value="add">
        <label>High (F)</label>
        <input type="number" name="highTemp" min="0" max="110" required />
        <br/>
        <label>Low (F)</label>
        <input type="number" name="lowTemp" min="0" max="110" required />
        <label>Wind Speed (MPH)</label>
        <input type="number" name="windSpd" min="0" max="50" required />
        <label>Sky Conditions</label>
        <input type="text" name="skyCond" required />
        <label>Precipitation (Inches)</label>
        <input type="number" name="precip" min="0" max="5" step="0.01" requierd />
        <button type="submit">Submit</button>
    </form>
</div>
<div>
    <iframe src="http://weather.rap.ucar.edu/radar/displayRad.php?icao=KUSA&prod=bref1&bkgr=gray&endDate=20170428&endTime=-1&duration=6" width="1220px" height="1000px"></iframe>
</div>

<%@include file="/footer.jsp" %>
