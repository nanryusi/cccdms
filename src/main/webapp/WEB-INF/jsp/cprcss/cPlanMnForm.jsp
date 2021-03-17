<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanMnForm : 월간보육계획서 수정화면
  Created by ryusi   on 2021-03-15.
  Modification Information
  ||수정자       ||수정일     ||수정내용
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="ko">
    <title>월간보육계획서 수정화면</title>
</head>
<body>
<script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
<form:form commandName="CplanMnVo" name="actionForm" method="post" enctype="multipart/form-data" >
    <form:hidden path="idx"/>
    <table class="bbs_write">
        <caption>샘플게시판</caption>
        <colgroup>
            <col width="10%">
            <col width="23%">
            <col width="10%">
            <col width="23%">
            <col width="10%">
            <col width="23%">
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
