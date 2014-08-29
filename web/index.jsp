<%--
  Created by IntelliJ IDEA.
  User: adrian.sacuiu
  Date: 8/25/2014
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" ng-app="qameleonApp">

<head>
    <meta charset="utf-8">
    <base href="/">
    <title>Qameleon</title>
    <link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" />
    <link rel="icon" type="image/ico" href="<c:url value="/resources/favicon.ico"/>" />
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/fonts/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/angular-strap/angular-motion.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/angular-strap/bootstrap-additions.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/angular-strap/libraries.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/lib/ng-tags-input/ng-tags-input.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/simple-sidebar.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/gantt.css"/>">


</head>

<body>
	<div data-ng-controller="LoginCtrl">
    <header data-ng-include="'/resources/views/header.html'"></header>
    <div id="wrapper" >
        <div data-ng-include="'/resources/views/sidebar.html'"></div>

        <div id="page-content-wrapper">
            <div >
                <ng-view></ng-view>
            </div>
        </div>
    </div>
	</div>

<script src="<c:url value="/resources/lib/jquery/jquery-1.11.0.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular/angular.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-bootstrap/ui-bootstrap-tpls.min.js"/>"></script>
<script src="<c:url value="/resources/scripts/bootstrap/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-route/angular-route.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-ui/ui-bootstrap-tpls-0.9.0.min.js"/>"></script>
<script src="<c:url value="/resources/lib/ng-tags-input/ng-tags-input.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-resource/angular-resource.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-animate/angular-animate.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-sanitize/angular-sanitize.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-strap/angular-strap.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-strap/angular-strap.tpl.min.js"/>"></script>
<script src="<c:url value="/resources/lib/angular-gantt.js" />"></script>
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.1.1/angular-cookies.min.js"/>"></script>

<script src="<c:url value="/resources/scripts/app.js"/>"></script>

<script src="<c:url value="/resources/scripts/controllers/projectController.js"/>"></script>
<script src="<c:url value="/resources/scripts/controllers/employeeController.js"/>"></script>
<script src="<c:url value="/resources/scripts/controllers/headerController.js"/>"></script>
<script src="<c:url value="/resources/scripts/controllers/leaveController.js"/>"></script>
<script src="<c:url value="/resources/scripts/controllers/restController.js"/>"></script>
<script src="<c:url value="/resources/scripts/controllers/calendarController.js"/>"></script>
<script src="<c:url value="/resources/scripts/controllers/timeSheetController.js"/>"></script>
<script src="<c:url value="scripts/controllers/loginController.js"/>"></script>

<script src="<c:url value="/resources/scripts/services/fireService.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/projectService.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/employeeService.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/leaveService.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/restService.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/calendarService.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/dataservice.js"/>"></script>
<script src="<c:url value="/resources/scripts/services/authService.js"/>"></script>
</body>

</html>
