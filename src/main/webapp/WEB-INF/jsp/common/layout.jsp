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
		<title>Insert title here</title>
		<link href="/static/css/sm_default.css" rel="stylesheet" type="text/css" /> 
		<link href="/static/css/sm_layout.css" rel="stylesheet" type="text/css" />
		<link href="/static/css/base.css" rel="stylesheet" type="text/css" /> 
		<link href="/static/css/content.css" rel="stylesheet" type="text/css" />
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	</head>
	<body>
		<div id="header">
			<page:applyDecorator name="top_menu"/>
		</div>
		<div id="lnb">
			<page:applyDecorator name="left_menu"/>
		</div>
		<div id="wrapper">
		<div class="size700">
			<decorator:body />
		</div>
		</div>
	</body>
</html>