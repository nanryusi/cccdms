<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanAdd : 연간보육계획안 등록화면
  Created by ryusi   on 2021-02-28.
  Modification Information
  ||수정자       ||수정일     ||수정내용
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="ko">
    <title>연간보육계획안 등록</title>
</head>
<body>
<script type="text/javascript" src="/static/js/cccdms/cm.function.js"></script>
    <section class="main">
        <div class="table-responsive">
            <input type="hidden" id="comm_code" value='${comm_code}'>
            <form:form commandName="CplanYrVo" name="actionForm" method="post" enctype="multipart/form-data" >
                <form:hidden path="school_code"/>
                <form:hidden path="teacher_div"/>
                <form:hidden path="class_code"/>
                <table class="table table-striped table-sm">
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
                        <td class="table-warning">년도</td>
                        <td>
                            <form:select id="sBox_yr" title="년도" path="year" class="selectpicker show-tick" data-style="btn-outline-primary" data-width="80px">
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
                        <td class="table-warning">부반</td>
                        <td>
                            <form:select id="comm_cl" title="부반" path="year" class="selectpicker show-tick" data-style="btn-outline-primary" data-width="120px">
                            </form:select>
                        </td>
                        <td class="table-warning">담임,부담임</td>
                        <td>
                            <div name="div_nm" id="div_nm"></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-warning">월</td>
                        <td>
                            <form:select id="sBox_mn" title="월" path="month" class="selectpicker show-tick" data-style="btn-outline-primary" data-width="80px">
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
                        <td class="table-warning">주차</td>
                        <td>
                            <form:select id="sBox_wk" title="주차" path="week" class="selectpicker show-tick" data-style="btn-outline-primary" data-width="80px">
                                <form:option value="1" >1주차</form:option>
                                <form:option value="2" >2주차</form:option>
                                <form:option value="3" >3주차</form:option>
                                <form:option value="4" >4주차</form:option>
                                <form:option value="5" >5주차</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-warning">어린이집 행사</td>
                        <td colspan="3"><form:textarea  id="txt_m_evnt" title="제목 입력" path="mainEvent" cols="75" rows="4" cssStyle="width:100%" /></td>
                    </tr>
                    <tr>
                        <td class="table-warning">유아의 주요경험</td>
                        <td colspan="3"><form:textarea id="txt_m_exp" title="내용 입력" path="mainExp" cols="75" rows="4" cssStyle="width:100%" />&nbsp;</td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
            <div name="div_m_bottom">
                <c:if test="${CplanYrVo.pathVariable eq 'insert' }">
                    <button id="btn_add_ajax" class="btn btn-primary">입력</button>
                </c:if>
                <c:if test="${CplanYrVo.pathVariable eq 'update' }">
                    <button id="btn_updateAction" class="btn btn-primary">수정</button>
                </c:if>
                <button id="btn_return" class="btn btn-primary">돌아가기</button>
            </div>
        </div>
    </section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="/static/js/cccdms/util/util.js"></script>
<script type="text/javascript" src="/static/js/cccdms/cprcss/cPlanYrAdd.js"></script>
<script>
    fn_comm_code("comm_cl", '${comm_code}');
</script>
</body>
</html>
