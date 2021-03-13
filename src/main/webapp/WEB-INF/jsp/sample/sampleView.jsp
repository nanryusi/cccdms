<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
<div class="sm_title">샘플게시판</div>
<form:form commandName="resultVO" name="viewForm" method="post" enctype="multipart/form-data" >
<form:hidden path="seqNo"/>
<table class="bbs_view">
	<caption>샘플게시판</caption>
	<colgroup>
		<col width="15%">
		<col width="35%">
		<col width="15%">
		<col width="35%">
	</colgroup>
	<tbody>
		<tr>
			<th scope="row"><span class="bar">작성자</span></th>
			<td><c:out value="${resultVO.regId }"/></td>
			<th scope="row"><span class="bar">작성일</span></th>
			<td><c:out value="${resultVO.regDt }"/></td>
		</tr>
		<tr>
			<th scope="row"><span class="bar">수정자</span></th>
			<td><c:out value="${resultVO.modId }"/></td>
			<th scope="row"><span class="bar">수정일</span></th>
			<td scope="row"><c:out value="${resultVO.modDt }"/></td>
		</tr>
		<tr>
			<th scope="row"><span class="bar">제목</span></th>
			<td colspan="3"><c:out value="${resultVO.title }"/></td>
		</tr>
		<tr>
			<th scope="row"><span class="bar">내용</span></th>
			<td colspan="3"><c:out value="${resultVO.contents }" escapeXml="false"/></td>
		</tr>
	</tbody>
</table>
</form:form>
<div class="form_btn">
	<div class="right">
		<ul>
			<li><a class="btn_l btn_focus" href="#" id="btn_update">수정</a></li>
			<li><a class="btn_l btn_focus" href="#" id="btn_delete">삭제</a></li>
		</ul>
	</div>
</div>