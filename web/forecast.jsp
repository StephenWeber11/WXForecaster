<%-- 
    Document   : forecast
    Created on : Apr 25, 2017, 7:03:09 PM
    Author     : Stephen
--%>
<%@include file="/header.jsp" %>
<div class="grid-100">
    <p class="center" id="multipleSubmission">${msg}</p>
    <p>${errorMessage}</p>
    <form action="forecast" method="post" id="forecastForm">
        <input type="hidden" name="action" value="add">
        <label>High (F)</label>
        <input type="number" name="highTemp" min="0" max="110" required />
        <label>Low (F)</label>
        <input type="number" name="lowTemp" min="0" max="110" required />
        <label>Wind Speed (MPH)</label>
        <input type="number" name="windSpd" min="0" max="50" required />
        <label>Sky Conditions</label>
        <select name="skyCond" required>
            <option value="" selected>&nbsp;</option>
            <option value="Clear">Clear</option>
            <option value="Mostly Sunny">Mostly Sunny</option>
            <option value="Partly Cloudy">Partly Cloudy</option>
            <option value="Mostly Cloudy">Mostly Cloudy</option>
            <option value="Cloudy">Cloudy</option>
            <option value="Fair">Fair</option>
        </select>
        <label>Precipitation (Inches)</label>
        <input type="number" name="precip" min="0" max="5" step="0.01" required />
        <button type="submit">Submit</button>
    </form>
    <div class="grid-100">
        <div class="grid-50">
            <div class="mosdata">
                <iframe src="http://www.nws.noaa.gov/cgi-bin/mos/getmav.pl?sta=KCLT"></iframe>
            </div>
        </div>
        <div class="grid-50">
            <div class="mosdata">
                <iframe src="http://www.nws.noaa.gov/cgi-bin/mos/getmet.pl?sta=KCLT"></iframe>
            </div>
        </div>
    </div>
</div>

<%@include file="/footer.jsp" %>
