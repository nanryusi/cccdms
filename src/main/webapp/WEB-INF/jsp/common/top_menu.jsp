<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1><a href="#" target="_parent"><em>CDMS</em>어린이집문서관리시스템</a></h1>
<div id="gnb">
	<!-- <ul>
		<li><a href="#" target="_parent">신청관리</a></li>
		<li><a href="#" target="_parent">게시판관리</a></li>
		<li><a href="#" target="_parent">운영관리</a></li>
		<li><a href="#" target="_parent">상담실관리</a></li>
		<li><a href="#" target="_parent">회원관리</a></li>
		<li><a href="#" target="_parent">어린이집관리</a></li>
		<li><a href="#" target="_parent">컨텐츠관리</a></li>
		<li><a href="#" target="_parent">관련사이트</a></li>
	</ul> -->
</div>
<div id="topNav">
	<span class="user">
		<!-- <img alt="" src="top_files/icon_user.png"> -->
		<b><c:out value="${LoginVO.userName}"/>(<c:out value="${LoginVO.id}"/>)</b>
		<a id="btn_logout" href="/cccdms/login/actionLogout.do" target="_parent">로그아웃</a>
	</span>
</div>