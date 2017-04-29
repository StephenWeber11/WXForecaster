<%-- 
    Document   : home
    Created on : Apr 25, 2017, 7:01:52 PM
    Author     : Stephen
--%>
<%@include file="header.jsp"%>
<div id="grid-100">
    <div id="homeBanner">
        <h1>Welcome to UNCC WxForecaster!</h1>
    </div>
    <div class="grid-100">
        <div id="homeSfcAnalysis">
            <iframe src="http://weather.rap.ucar.edu/surface/displaySfc.php?region=clt" align="middle"></iframe>
        </div>
    </div>
    <div class="grid-100">
        <div class="grid-50">
            <div class="center">
                <h2>About</h2>
                <br/>
                <p>UNCC WxForecaster was designed for users of all ages to be able to look at weather data and make their own forecasts. 
                    Through firsthand experience, users will begin to understand the complex task of weather prediction. The hope is to
                    encourage more people to learn more about meteorological forecasting and phenomena.
                </p>
                <br/>
                <p>Take a look around and enjoy your stay!</p>
            </div>
        </div>
        <div class="grid-50">
            <div id="loginContainer">
                <p><i>${msg}</i></p>
                <h2 id="registerAccount" class="center">Login</h2>
                <br/>
                <form action="user" method="post">
                    <input type="hidden" name="action" value="login">
                    <label >Email Address *</label>
                    <input type="email" name="email" class="registerFormInput" required/>
                    <label >Password *</label>
                    <input type="password" name="password" class="registerFormInput" required/><br>
                    <input type="submit" value="Log in" id="login_button">
                    <br>
                </form>
                <br/>
                <a href="signup.jsp" id="sign_up_link">Sign up for a new account</a>
            </div>
        </div>
    </div>
    <br/><br/>
</div>
<%@include file="/footer.jsp" %>