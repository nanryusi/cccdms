<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanYrMain : 영유아 안전교육 일지
  Created by denicola4   on 2021-04-12.
  Modification Information
  ||수정자       ||수정일     ||수정내용
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
    <section class="main">
        <script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
        <div class="sm_title">영유아 안전교육 일지</div>
        <table class="data_list">
            <caption>영유아 안전교육 일지</caption>
            <colgroup>
                <col width="5%">
                <col width="*">
                <col width="*">
                <col width="10%">
                <col width="10%">
            </colgroup>
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일</th>
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
                            <td><a href="<c:url value='/cccdms/cprcss/cplanWk/view.do?idx=${result.idx }'/>"><c:out value="${result.title }"/></a></td>
                            <td><c:out value="${result.contents }"/></td>
                            <td><c:out value="${result.regId }"/></td>
                            <td><c:out value="${result.regDt }"/></td>
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

    </section>
    </body>
</html>
