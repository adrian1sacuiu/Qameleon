<%--
  Created by IntelliJ IDEA.
  User: adrian.sacuiu
  Date: 8/25/2014
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.misc.GoogleAuthHelper"%>
<!doctype html>
<html lang="en">
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
    <center id="login-center">
        <img style="padding-bottom:20px" src="<c:url value="/resources/img/login-logo.png" />" alt="Qualitance Log In Portal">
        <div class="well" style="width:300px;height:100px">
            <center>
                <% final GoogleAuthHelper helper = new GoogleAuthHelper(); %>
                <a href="<%= helper.buildLoginUrl()%>"><button type="button" class="btn btn-primary btn-color">Login with your Qualitance ID</button></a>
                <% session.setAttribute("state", helper.getStateToken()); %>
            </center>
            <br/>
            <center>
                <a href="#">Need help?</a>
            </center>
        </div>
        <div class="alert alert-danger alert-dismissible" role="alert" data-ng-show="false" style="width:300px">
            <button type="button" class="close" data-dismiss="alert">
                <span aria-hidden="true">&times;</span>
                <span class="sr-only">Close</span>
            </button>
            <strong>Something went wrong!</strong><br>Please try again later.
        </div>
    </center>
</body>
</html>