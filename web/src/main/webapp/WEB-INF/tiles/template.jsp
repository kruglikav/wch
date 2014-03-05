<%--
  Created by IntelliJ IDEA.
  User: Kruglik
  Date: 10/28/13
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--<link rel="shortcut icon" href="../../assets/ico/favicon.ico">-->

    <title>wch</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">

    <link href="<c:url value='/css/glDatePicker.default.css'/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/template.css'/>" rel="stylesheet">
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.js'/>"></script>
    <script src="<c:url value='/js/glDatePicker.min.js'/>"></script>
</head>
<body>

<div class="page-container">
    <tiles:insertAttribute name="header"/>
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-left">
            <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                <tiles:insertAttribute name="menu"/>
            </div>
            <div class="col-xs-12 col-sm-9">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>

<script type='text/javascript'>

    $(document).ready(function() {
        $('[data-toggle=offcanvas]').click(function() {
            $('.row-offcanvas').toggleClass('active');
        });
    });

</script>
</body>
</html>