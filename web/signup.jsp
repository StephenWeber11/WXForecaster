<%-- 
    Document   : signup
    Created on : Apr 25, 2017, 7:02:16 PM
    Author     : Stephen
--%>

<%@include file="/header.jsp"%>
<div id="signUpForm">
    <form action="user" method="post">
        <input type="hidden" name="action" value="create"/>
        <input type="text" name="First Name" value="firstName"/>
        <input type="text" name="Last Name" value="lastName"/>
        <input type="email" name="Email" value="email"/>
        <input type="password" name="Password" value="password"/>
        <input type="submit" value="Create Account"/>
    </form>
</div>
