<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
		<meta http-equiv="content-language" content="ko">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Insert title here</title>
		<link href="/static/css/sm_default.css" rel="stylesheet" type="text/css" /> 
		<link href="/static/css/sm_layout.css" rel="stylesheet" type="text/css" />
		<link href="/static/css/base.css" rel="stylesheet" type="text/css" /> 
		<link href="/static/css/content.css" rel="stylesheet" type="text/css" />
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<form:form commandName="joinVO" name="actionForm" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="returnUrl" value="<c:url value='/cccdms/sample/updateForm.do'/>"/>
		<table class="bbs_write">
			<caption>사용자 가입</caption>
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</form:form>
		<div class="form_btn">
			<div class="right">
				<ul>
					<li><a class="btn_l btn_focus" href="#" id="btn_add">입력</a></li>
				</ul>
			</div>
		</div>
	</body>
</html>