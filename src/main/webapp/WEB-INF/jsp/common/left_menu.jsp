<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>샘플게시판</h2>
<ul>
	<!-- <li class="sel">
		<a href="/cccdms/cprcss/cplanyr/mainPage.do">연간보육계획안</a>
	</li>
	<li class="sel">
		<a href="/cccdms/cprcss/cplanMn/mainPage.do">월간보육계획안</a>
	</li>
	<li class="sel">
		<a href="/cccdms/cprcss/cplanWk/mainPage.do">주간보육일지</a>
	</li> -->
	<li class="sel" >
		<a href="/cccdms/sample/main.do">샘플게시판</a>
	</li>
	<c:forEach var="resultLeftMenu" items="${resultLeftMenuList}" varStatus="status">
	<li <c:if test="${resultLeftMenu.parMenuCd eq param.menuCd}">class="sel"</c:if>><a href="<c:out value="${resultLeftMenu.menuUrl}"/>?menuCd=<c:out value="${resultLeftMenu.parMenuCd}"/>" target="_self"><c:out value="${resultLeftMenu.menuNm}"/></a></li>
	</c:forEach>
</ul>