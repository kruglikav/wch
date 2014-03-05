<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 10/28/13
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/home.htm" />'>WCH</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <sec:authorize access="isAuthenticated()">
                    <li><a>Hello ${userName}</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href='<spring:url value="/j_spring_security_logout" />'> Logout</a></li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <li><a href='<spring:url value="/registration.htm" />'> Registration</a></li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <li class="active"><a href='<spring:url value="/login.htm" />'> Login</a></li>
                </sec:authorize>

            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

</body>
</html>