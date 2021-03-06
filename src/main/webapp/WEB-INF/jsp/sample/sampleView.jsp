<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="table-responsive">
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
			<td><c:out value="${resultVO.regId }"/></td>
			<td>작성일</td>
			<td><c:out value="${resultVO.regDt }"/></td>
		</tr>
		<tr>
			<td>수정자</td>
			<td><c:out value="${resultVO.modId }"/></td>
			<td>수정일</td>
			<td><c:out value="${resultVO.modDt }"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><c:out value="${resultVO.title }"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3"><c:out value="${resultVO.contents }"/></td>
		</tr>
	</tbody>
</table>
</div>