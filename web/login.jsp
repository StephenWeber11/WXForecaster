<%-- 
    Document   : login
    Created on : Apr 25, 2017, 7:02:28 PM
    Author     : Stephen
--%>
<%@include file="header.jsp"%>
<div id="loginPageLarger">
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
<%@include file="footer.jsp" %>
