<%-- 
    Document   : signup
    Created on : Apr 25, 2017, 7:02:16 PM
    Author     : Stephen
--%>

<%@include file="/header.jsp"%>
<div id="signUpForm">
    <form action="user" method="post">
        <input type="hidden" name="action" value="create"/>
        <input type="text" name="firstName" value="firstName"/>
        <input type="text" name="lastName" value="lastName"/>
        <input type="email" name="email" value="email"/>
        <input type="password" name="password" value="password"/>
        <input type="submit" value="Create Account"/>
    </form>
    <p>${message}</p>
    <p>${msg}</p>
</div>
<%@include file="/footer.jsp" %>
