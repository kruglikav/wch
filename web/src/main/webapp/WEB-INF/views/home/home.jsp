<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 10/28/13
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>Home page</h1>
    </div>
    <c:if test="${not empty reg_msg}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p>${reg_msg}</p>
        </div>
    </c:if>


</div>


</body>
</html>