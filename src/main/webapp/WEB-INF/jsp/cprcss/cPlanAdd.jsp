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
        </div>
        <div>

        </div>
        <div name="div_m_bottom">
            <button id="btn_Save">저장</button>
        </div>
    </div>
    <script type="text/javascript" src="/static/js/cccdms/cprcss/cPlanYrAdd.js"></script>
    <script type="text/javascript">
        fn_comm_code("comm_cl", '${comm_cl}');
    </script>
</body>
</html>
