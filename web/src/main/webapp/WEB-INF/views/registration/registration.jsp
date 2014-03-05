<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 2/23/14
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>

<div class="container">
    <spring:url var="addUserUrl" value="/registration.htm" />
    <form:form class="form-signin" role="form" method="POST" action="${addUserUrl}" modelAttribute="user">
        <h2 class="form-signin-heading">Please registration</h2>

        <form:input path="name" class="form-control" placeholder="Name"/>

        <form:password path="password" class="form-control" placeholder="Password"/>

        <form:password path="confirmPassword" class="form-control" placeholder="Confirm password"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
    <c:if test="${not empty reg_msg}">
        <div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p>${reg_msg}</p>
        </div>
    </c:if>

</div> <!-- /container -->

</body>
</html>