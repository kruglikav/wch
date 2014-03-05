<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 2/23/14
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>

<div class="container">


    <spring:url var="addWorkerUrl" value="/admin/addWorker.htm"/>
    <form:form method="POST" action="${addWorkerUrl}" modelAttribute="workerDTO">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>JobType</th>
                <th>Skill</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${workerList}" var="worker" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${worker.name}</td>
                    <td>${worker.jobType.name}</td>
                    <td>${worker.skill.name}</td>
                    <td><a href='<spring:url value="/admin/deleteWorker.htm?id=${worker.id}"/>'><span class="glyphicon glyphicon-remove red"></span></a></td>
                </tr>
            </c:forEach>

            <tr>
                <td>

                </td>
                <td>
                    <form:input path="name" placeholder="Name"/>
                </td>
                <td>
                    <form:select path="jobTypeId" placeholder="JobType" items="${jobTypeList}" itemLabel="name"
                                 itemValue="id"/>
                </td>
                <td>
                    <form:select path="skillId" placeholder="Skill" items="${skillList}" itemLabel="name"
                                 itemValue="id"/>
                </td>
                <td>
                    <button type="submit" class="btn btn-link btn-lg">
                        <span class="glyphicon glyphicon-plus green"></span>
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
<!-- /container -->

</body>
</html>