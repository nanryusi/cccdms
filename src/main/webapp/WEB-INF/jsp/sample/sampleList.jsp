<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="sm_title">샘플게시판</div>
<table class="data_list">
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
			<th scope="col">번호</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">작성일</th>
			<th scope="col">조회수</th>
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
				<td><c:out value="${result.regNm }"/></td>
				<td><c:out value="${result.regDt }"/></td>
				<td><c:out value="${result.viewCnt }"/></td>
			</tr>
		</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
<div id="pager">
	<ul class="pagination">
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_noticeList" />    
	</ul>
</div>
<div class="form_btn">
	<div class="right">
		<ul>
  			<li><a class="btn_l btn_focus" href="#" id="btn_addPage">신규 작성</a></li>
		</ul>
	</div>
</div>