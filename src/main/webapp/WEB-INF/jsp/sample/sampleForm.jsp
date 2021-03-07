<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
<div class="table-responsive">
<form:form commandName="sampleVO" name="actionForm" method="post" enctype="multipart/form-data" >
<form:hidden path="seqNo"/>
<table class="table table-striped table-sm">
	<caption>샘플게시판</caption>
	<colgroup>
		<col width="15%">
		<col width="35%">
		<col width="15%">
		<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<td>작성자</td>
			<td><form:input title="작성자 입력" path="regId" cssStyle="width:100%" />&nbsp;<form:errors path="regId" /></td>
			<td>작성일</td>
			<td><form:input title="작성일 입력" path="regDt" cssStyle="width:100%" />&nbsp;<form:errors path="regDt" /></td>
		</tr>
		<tr>
			<td>수정자</td>
			<td><form:input title="수정자 입력" path="modId" cssStyle="width:100%" />&nbsp;<form:errors path="modId" /></td>
			<td>수정일</td>
			<td><form:input title="수정일 입력" path="modDt" cssStyle="width:100%" />&nbsp;<form:errors path="modDt" /></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><form:input title="제목 입력" path="title" cssStyle="width:100%" />&nbsp;<form:errors path="title" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3"><form:textarea title="내용 입력" path="contents" cols="75" rows="4" cssStyle="width:100%" />&nbsp;<form:errors path="contents" /></td>
		</tr>
	</tbody>
</table>
</form:form>
<div name="div_m_bottom">
	<c:if test="${sampleVO.pathVariable eq 'insert' }">
	<button id="btn_add">입력</button>
	</c:if>
	<c:if test="${sampleVO.pathVariable eq 'update' }">
	<button id="btn_updateAction">수정</button>
	</c:if>
</div>
</div>