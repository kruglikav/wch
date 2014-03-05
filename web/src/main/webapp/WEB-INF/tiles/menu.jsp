<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 2/27/14
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>

<spring:url value="/home.htm" var="home"></spring:url>
<spring:url value="/admin/workers.htm" var="addWorker"></spring:url>
<spring:url value="/user/addOrder.htm" var="addOrder"></spring:url>
<ul class="nav">
    <li class="active"><a href="${home}">Home</a></li>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="${addWorker}">Workers</a></li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <li><a href="${addOrder}">Orders</a></li>
    </sec:authorize>
    <li><a href="#">Link 2</a></li>
    <li><a href="#">Link 3</a></li>
</ul>

</body>
</html>