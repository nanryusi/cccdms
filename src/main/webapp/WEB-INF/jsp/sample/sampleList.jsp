<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>샘플게시판</h2>
<div class="table-responsive">
<table class="table table-striped table-sm">
	<caption>샘플게시판</caption>
	<colgroup>
		<col width="5%">
		<col width="*">  
		<col width="10%">
		<col width="10%">
		<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${resultCnt == 0}">
		<tr>
			<td nowrap colspan="5">데이터가 없습니다.</td>  
		</tr>
		</c:when>
		<c:otherwise>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td><c:out value="${(searchVO.pageIndex-1) * searchVO.pageSize + status.count}"/></td>
				<td><a href="<c:url value='/cccdms/sample/view.do?seqNo=${result.seqNo }'/>"><c:out value="${result.title }"/></a></td>
				<td><c:out value="${result.regId }"/></td>
				<td><c:out value="${result.regDt }"/></td>
				<td><c:out value="${result.viewCnt }"/></td>
			</tr>
		</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
</div>
<div id="paging_div">
	<ul class="pagination">
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_noticeList" />    
	</ul>
</div>