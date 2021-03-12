<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
<div class="sm_title">샘플게시판</div>
<form:form commandName="sampleVO" name="actionForm" method="post" enctype="multipart/form-data" >
<form:hidden path="seqNo"/>
<table class="bbs_write">
	<caption>샘플게시판</caption>
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
				<c:import charEncoding="utf-8" url="/cccdms/fms/selectFileInfs.do" >
					<%-- <c:param name="atchFileId" value="${indvdlSchdulManageVO.atchFileId}" /> --%>
				</c:import>
			</td>
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