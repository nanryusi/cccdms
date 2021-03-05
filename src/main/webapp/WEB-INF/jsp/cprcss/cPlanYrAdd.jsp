<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanAdd : 연간보육계획안 등록화면
  Created by ryusi   on 2021-02-28.
  Modification Information
  ||수정자       ||수정일     ||수정내용
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="ko">
    <title>연간보육계획안 등록</title>
</head>
<body>
    <div class="col-lg-9 my-4 mb-4">
        <div name="div_m_top">프린터, 파일저장</div>
        <%--<div name="div_m_search"></div>--%>
        <div name="div_m_upper">
            <div name="school_nm"></div>
            <div name="comm_code">분반
                <select name="comm_cl" id="comm_cl"></select>
            </div>
            <div name="div_nm" id="div_nm">빈값</div>
            <div>
                <select id="sBox_yr">
                    <option value="2020">2020년</option>
                    <option value="2021">2021년</option>
                    <option value="2022">2022년</option>
                    <option value="2023">2023년</option>
                    <option value="2024">2024년</option>
                    <option value="2025">2025년</option>
                    <option value="2026">2026년</option>
                    <option value="2027">2027년</option>
                    <option value="2028">2028년</option>
                    <option value="2029">2029년</option>
                    <option value="2030">2030년</option>
                </select>
            </div>
        </div>
        <div>
        <table>
            <thead>
            <tr>
                <th>월</th>
                <th>주</th>
                <th>어린이집 행사</th>
                <th>유아의 주요경험<br>
                    (명절, 기관 적응, 특별한 날 등)
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <select id="sBox_mn">
                        <option value="01">1월</option>
                        <option value="02">2월</option>
                        <option value="03">3월</option>
                        <option value="04">4월</option>
                        <option value="05">5월</option>
                        <option value="06">6월</option>
                        <option value="07">7월</option>
                        <option value="08">8월</option>
                        <option value="09">9월</option>
                        <option value="10">10월</option>
                        <option value="11">11월</option>
                        <option value="12">12월</option>
                    </select>
                </td>
                <td>
                    <select id="sBox_wk">
                        <option value="1">1주차</option>
                        <option value="2">2주차</option>
                        <option value="3">3주차</option>
                        <option value="4">4주차</option>
                        <option value="5">5주차</option>
                    </select>
                </td>
                <td><textarea id="txt_m_evnt"></textarea></td>
                <td><textarea id="txt_m_exp"></textarea></td>
            </tr>
            </tbody>
        </table>
        </div>
        <div name="div_m_bottom">
            <button id="btn_add">저장</button>
        </div>
    </div>
    <script type="text/javascript" src="/static/js/cccdms/util/util.js"></script>
    <script type="text/javascript" src="/static/js/cccdms/cprcss/cPlanYrAdd.js"></script>
    <script type="text/javascript">
        fn_comm_code("comm_cl", '${comm_cl}');
    </script>
</body>
</html>
