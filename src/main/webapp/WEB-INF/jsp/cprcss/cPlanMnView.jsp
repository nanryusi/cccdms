<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanMnForm : 월간보육계획서 상세화면
  Created by ryusi   on 2021-03-19.
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
</head>
<body>
<script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
<section class="main">
<div class="sm_title">월간보육계획서 상세내역</div>
<form:form commandName="CplanMnDtlVo" name="viewForm" method="post" enctype="multipart/form-data" >
    <form:hidden path="idx"/>
    <table class="bbs_write">
        <caption>월간보육계획서 상세내역</caption>
        <colgroup>
            <col width="15%">
            <col width="35%">
            <col width="15%">
            <col width="35%">
        </colgroup>
        <tbody>
        <tr>
            <th scope="row">최초작성자</th>
            <td>
                <form:input title="최초작성자" path="regNm" cssStyle="width:70%" readonly="true"/>&nbsp;<form:errors path="regNm" />
                <form:input title="최초작성일" path="regDt" cssStyle="width:30%" readonly="true"/>&nbsp;<form:errors path="regDt" />
            </td>
            <th scope="row">최종수정자</th>
            <td>
                <form:input title="최종수정자" path="modNm" cssStyle="width:70%" readonly="true"/>&nbsp;<form:errors path="modNm" />
                <form:input title="최종수정일" path="modDt" cssStyle="width:30%" readonly="true"/>&nbsp;<form:errors path="modDt" />
            </td>
        </tr>
        <tr>
            <th scope="row">년도</th>
            <td>
                <form:select id="sBox_yr" title="년도" path="stndYear">
                    <form:option value="2020" >2020년</form:option>
                    <form:option value="2021" >2021년</form:option>
                    <form:option value="2022" >2022년</form:option>
                    <form:option value="2023" >2023년</form:option>
                    <form:option value="2024" >2024년</form:option>
                    <form:option value="2025" >2025년</form:option>
                    <form:option value="2026" >2026년</form:option>
                    <form:option value="2027" >2027년</form:option>
                    <form:option value="2028" >2028년</form:option>
                    <form:option value="2029" >2029년</form:option>
                    <form:option value="2030" >2030년</form:option>
                </form:select>
            </td>
            <th scope="row">부반</th>
            <td>
                <select class="form-control" id="sBox_cl" name="sBox_cl">
                    <c:forEach items="${CodeListClass}" var="opList" >
                        <option value="${opList.cl_cd}" >${opList.cl_nm}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th scope="row">기준월</th>
            <td>
                <form:select id="sBox_mn" title="월" path="stndMonth">
                    <form:option value="01" >1월</form:option>
                    <form:option value="02" >2월</form:option>
                    <form:option value="03" >3월</form:option>
                    <form:option value="04" >4월</form:option>
                    <form:option value="05" >5월</form:option>
                    <form:option value="06" >6월</form:option>
                    <form:option value="07" >7월</form:option>
                    <form:option value="08" >8월</form:option>
                    <form:option value="09" >9월</form:option>
                    <form:option value="10" >10월</form:option>
                    <form:option value="11" >11월</form:option>
                    <form:option value="12" >12월</form:option>
                </form:select>
            </td>
            <th scope="row">주차</th>
            <td>
                <form:select id="sBox_wk" title="주차" path="stndWeek">
                    <form:option value="1" >1주차</form:option>
                    <form:option value="2" >2주차</form:option>
                    <form:option value="3" >3주차</form:option>
                    <form:option value="4" >4주차</form:option>
                    <form:option value="5" >5주차</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th scope="row">놀이 주제</th>
            <td colspan="3"><form:textarea title="내용 입력" path="title" cols="75" rows="4" cssStyle="width:100%" readonly="true"/>&nbsp;<form:errors path="title" /></td>
        </tr>
        <tr>
            <th scope="row">주요 경험</th>
            <td colspan="3"><form:textarea title="내용 입력" path="mainExp" cols="75" rows="4" cssStyle="width:100%" readonly="true"/>&nbsp;<form:errors path="mainExp" /></td>
        </tr>
        <tr>
            <th scope="row">야외 활동</th>
            <td colspan="3"><form:textarea title="내용 입력" path="outdoorAct" cols="75" rows="4" cssStyle="width:100%" readonly="true"/>&nbsp;<form:errors path="outdoorAct" /></td>
        </tr>
        <tr>
            <th scope="row">주요 활동</th>
            <td colspan="3"><form:textarea title="내용 입력" path="mainAct" cols="75" rows="4" cssStyle="width:100%" readonly="true"/>&nbsp;<form:errors path="mainAct" /></td>
        </tr>
        <tr>
            <th scope="row">놀이 자료</th>
            <td colspan="3"><form:textarea title="내용 입력" path="playMtl" cols="75" rows="4" cssStyle="width:100%" readonly="true"/>&nbsp;<form:errors path="playMtl" /></td>
        </tr>
        <tr>
            <th scope="row">행사 일정</th>
            <td colspan="3"><form:textarea title="내용 입력" path="eventPlan" cols="75" rows="4" cssStyle="width:100%" readonly="true"/>&nbsp;<form:errors path="eventPlan" /></td>
        </tr>
        </tbody>
    </table>
</form:form>
<div class="form_btn">
    <div class="left">
        <ul>
            <li><a class="btn_l btn_focus" href="#" id="btn_delete">삭제</a></li>
        </ul>
    </div>
    <div class="right">
        <ul>
            <li><a class="btn_l btn_focus" href="#" id="btn_update">수정</a></li>

        </ul>
    </div>
</div>
</section>
</body>
</html>
