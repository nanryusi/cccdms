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
		<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
		<link href="/static/css/dashboard.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="/static/js/bootstrap/bootstrap.bundle.min.js"></script>
		<script src="/static/js/dashboard.js"></script>
		<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
	</head>
	<body>
		<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
			<page:applyDecorator name="top_menu"/>
		</header>
		<div class="container-fluid">
			<div class="row">
			<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
			<div class="position-sticky pt-3">
			<page:applyDecorator name="left_menu"/>
			</div>
			</nav>
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
			<decorator:body />
			</main>
			</div>
		</div>
	</body>
</html>