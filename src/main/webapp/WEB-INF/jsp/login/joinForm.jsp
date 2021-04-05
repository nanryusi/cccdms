<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Insert title here</title>
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
					<th scope="row">제목</th>
					<td colspan="3"><form:input title="제목 입력" path="title" cssStyle="width:100%" />&nbsp;<form:errors path="title" /></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td colspan="3"><form:textarea title="내용 입력" path="contents" cols="75" rows="4" cssStyle="width:100%" />&nbsp;<form:errors path="contents" /></td>
				</tr>
				<tr>
					<th scope="row">첨부파일</th>
					<td colspan="3">
						 <input name="file" id="egovComFileUploader" type="file" />
						<c:import url="/cccdms/fms/selectFileInfs.do" charEncoding="utf-8">
							<c:param name="param_atchFileId" value="${sampleVO.atchFileId}" />
							<c:param name="param_updateFlag" value="Y" />
						</c:import>
					</td>
				</tr>
			</tbody>
		</table>
		</form:form>
		<div class="form_btn">
			<div class="right">
				<ul>
		  			<c:if test="${sampleVO.pathVariable eq 'insert' }">
					<li><a class="btn_l btn_focus" href="#" id="btn_add">입력</a></li>
					</c:if>
					<c:if test="${sampleVO.pathVariable eq 'update' }">
					<li><a class="btn_l btn_focus" href="#" id="btn_updateAction">수정</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</body>
</html>