<%-- 
    Document   : signup
    Created on : Apr 25, 2017, 7:02:16 PM
    Author     : Stephen
--%>

<%@include file="/header.jsp"%>
<div id="signUpForm">
    <p>${message}</p>
    <p>${msg}</p>
    <br/>
    <h2 id="registerAccount">Create an account</h2>
    <form action="user" method="post">
        <input type="hidden" name="action" value="create"/>
        <input type="text" name="firstName" class="registerFormInput" placeholder="First Name*"/>
        <input type="text" name="lastName" class="registerFormInput" placeholder="Last Name*"/>
        <input type="email" name="email" class="registerFormInput" placeholder="Email Address*"/>
        <input type="password" name="password" class="registerFormInput" placeholder="Password*"/>
        <input type="password" name="confirmPass" class="registerFormInput" placeholder="Confirm Password*"/>
        <input type="submit" value="Create Account"/>
    </form>
</div>
<%@include file="/footer.jsp" %>
