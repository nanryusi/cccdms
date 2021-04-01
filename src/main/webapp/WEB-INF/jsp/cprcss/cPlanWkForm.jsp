<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanMnForm : 주간보육일지 수정화면
  Created by ryusi   on 2021-03-29.
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
<div class="sm_title">주간보육일지</div>
<form:form commandName="CplanWkVo" name="actionForm" method="post" enctype="multipart/form-data" >
    <form:hidden path="idx"/>
    <table class="bbs_write">
        <caption>주간보육일지</caption>
        <colgroup>
            <col width="15%">
            <col width="15%">
            <col width="15%">
            <col width="15%">
            <col width="15%">
            <col width="*">
        </colgroup>
        <tbody>
        <tr>
            <th scope="row">년도</th>
            <td colspan="2">
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
            <td colspan="2">
                <select class="form-control" id="sBox_cl" name="sBox_cl">
                    <c:forEach items="${CodeListClass}" var="opList" >
                        <option value="${opList.cl_cd}" >${opList.cl_nm}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th scope="row">기간</th>
            <td colspan="2">
                <input type="date" id="startDay" value="${startDay}">
                ~
                <input type="date" id="endDay" value="${endDay}">
            </td>
            <th scope="row">통합보육</th>
            <td colspan="2">
            </td>
        </tr>
        <tr>
            <th scope="row">일과(시간)</th>
            <th scope="row" colspan="5"> 계획 및 실행</th>
        </tr>
        <!-- 일상생확 -->
        <tr>
            <th scope="row" rowspan="3">일상<br>생활</th>
            <th scope="row">간식<br>(09:00 ~ 09:20)<br>(15:40 ~ 16:00)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="morningAct" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>

            <th scope="row">점심식사<br>(12:20 ~ 13:20)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="lunchAct" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>

            <th scope="row">낮잠 및 휴식<br>(13:20 ~ 14:20)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="breakTimeAct" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <!-- 놀이 -->
        <tr>
            <th scope="row" rowspan="2">놀이</th>
            <th scope="row">실내놀이<br>(09:20 ~ 10:40)<br>(14:20 ~ 15:40)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="indoorAct" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>

            <th scope="row">바깥놀이(대체)<br>(11:00 ~ 12:20)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="outdoorAct" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <!-- 활동 -->
        <tr>
            <th scope="row">활동<br>(10:40 ~ 11:00)</th>
            <td colspan="5"><form:textarea title="내용 입력" path="additAct" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <!-- 날짜별 사항 -->
        <tr>
            <th scope="row">날짜</th>
            <th scope="row" colspan="4">놀이 평가 및 다음날 지원 계획</th>
            <th scope="row">반운영 특이사항</th>
        </tr>
        <tr>
            <th>첫째날(월)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="firstEvalPlan" cols="75" rows="4" cssStyle="width:100%" /></td>
            <td><form:textarea title="내용 입력" path="firstOprSpcf" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>
            <th>둘째날(화)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="secondEvalPlan" cols="75" rows="4" cssStyle="width:100%" /></td>
            <td><form:textarea title="내용 입력" path="secondOprSpcf" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>
            <th>셋째날(수)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="thirdEvalPlan" cols="75" rows="4" cssStyle="width:100%" /></td>
            <td><form:textarea title="내용 입력" path="thirdOprSpcf" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>
            <th>넷째날(목)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="forthEvalPlan" cols="75" rows="4" cssStyle="width:100%" /></td>
            <td><form:textarea title="내용 입력" path="forthOprSpcf" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>
            <th>다섯째날(금)</th>
            <td colspan="4"><form:textarea title="내용 입력" path="fifthEvalPlan" cols="75" rows="4" cssStyle="width:100%" /></td>
            <td><form:textarea title="내용 입력" path="fifthOprSpcf" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        <tr>
            <th>다음주 <br>예상 놀이 및 <br>지원 계획</th>
            <td colspan="5"><form:textarea title="내용 입력" path="nextEvalPlan" cols="75" rows="4" cssStyle="width:100%" /></td>
        </tr>
        </tbody>
    </table>
</form:form>
<div class="form_btn">
    <div class="right">
        <ul>
            <c:if test="${CplanWkVo.pathVariable eq 'insert' }">
                <li><a class="btn_l btn_focus" href="#" id="btn_add_ajax">입력</a></li>
            </c:if>
            <c:if test="${CplanWkVo.pathVariable eq 'update' }">
                <li><a class="btn_l btn_focus" href="#" id="btn_mod_ajax">수정</a></li>
            </c:if>
            <li><a class="btn_l btn_focus" href="#" id="btn_return">돌아가기</a></li>
        </ul>
    </div>
</div>
</section>
<script type="text/javascript" src="/static/js/cccdms/util/util.js"></script>
<script type="text/javascript" src="/static/js/cccdms/cprcss/cPlanWkForm.js"></script>
</body>
</html>
