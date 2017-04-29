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
                <p>This application serves as a platform for everyday people to make their
                    own forecasts and email them to their friends and family!</p>
                <br/>
                <p>Take a look around and enjoy your stay!</p>
            </div>
        </div>
        <div class="grid-50">
            <div id="loginContainer">
                <p><i>${msg}</i></p>
                <form action="user" method="post">
                    <input type="hidden" name="action" value="login">
                    <label >Email Address *</label>
                    <input type="email" name="email" required/> <br><br>
                    <label >Password *</label>
                    <input type="password" name="password" required/><br>
                    <label>&nbsp;</label>
                    <input type="submit" value="Log in" id="login_button">
                    <br>
                </form>
                <a href="signup.jsp" id="sign_up_link">Sign up for a new account</a>
            </div>
        </div>
    </div>
    <br/><br/>
</div>
<%@include file="/footer.jsp" %>