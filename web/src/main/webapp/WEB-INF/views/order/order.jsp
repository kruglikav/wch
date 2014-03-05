<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 11/2/13
  Time: 2:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>

<div class="container">
    <spring:url var="addOrderUrl" value="/user/addOrder.htm"/>

    <form:form method="POST" action="${addOrderUrl}" modelAttribute="orderDTO">
        <table class="table">
            <thead>
            <tr>

                <th>JobType</th>
                <th>Job</th>
                <th>Address</th>
                <th>Date</th>
                <th>Worker</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderList}" var="i">
                <tr>
                    <td>${i.job.jobType.name}</td>
                    <td>${i.job.description}</td>
                    <td>${i.address.name}</td>
                    <td><fmt:formatDate type="date" value="${i.startTime}" /></td>
                    <td>${i.worker.name}</td>
                </tr>
            </c:forEach>
            <tr>
                <td><select id="jobTypeSelect">
                    <option value=""></option>
                    <c:forEach items="${jobTypeList}" var="jobType">
                        <option value="${jobType.id}">${jobType.name}</option>
                    </c:forEach>
                </select></td>
                <td><form:select id="jobSelect" path="jobId"/></td>
                <td>
                    <form:input path="address" list="addressDataList" class="textfield"/>
                    <datalist id="addressDataList">
                        <c:forEach var="addr" items="${addressList}">
                            <option value="${addr.name}"/>
                        </c:forEach>
                    </datalist>
                </td>

                <td>
                    <form:input path="startTime" id='datepickerSet'/>
                <td>
                    <button type="submit" class="btn btn-lg btn-link">
                        <span class="glyphicon glyphicon-plus green">Add</span>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <c:if test="${not empty msg}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p>${msg}</p>
        </div>
    </c:if>
    <c:if test="${not empty err_msg}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p>${err_msg}</p>
        </div>
    </c:if>

</div>
<script src="<c:url value='/js/jobs.js'/>"></script>
<script type="text/javascript">
    $('#datepickerSet').glDatePicker();
</script>

</body>
</html>