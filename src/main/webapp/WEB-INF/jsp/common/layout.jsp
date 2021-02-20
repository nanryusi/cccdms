<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
</head>
</head>
<body class="pt-5">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/bootstrap/bootstrap.js"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"><page:applyDecorator name="top_menu"/></nav>
<!-- <div class="sidebar-wrapper"></div> -->
<div class="container">
<div class="row">
<page:applyDecorator name="left_menu"/>
<decorator:body />
</div>
</div>
</body>
</html>