
<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 11/10/13
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>

<div class="container">
    <spring:url var="loginUrl" value="/j_spring_security_check" />
    <form class="form-signin" role="form" name="loginForm" action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Login" required autofocus name="j_username">
        <input type="password" class="form-control" placeholder="Password" required name="j_password">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
    <c:if test="${param.fail == 'true'}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p>Неверный логин или пароль</p>
        </div>
    </c:if>

</div> <!-- /container -->

</body>
</html>