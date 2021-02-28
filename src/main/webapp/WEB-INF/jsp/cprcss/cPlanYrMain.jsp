<%-- Copyright 2021. Team oktop all rights reserved. --%>

<%--
  cPlanYrMain : 연간보육계획안
  Created by ryusi   on 2021-02-20.
  Modification Information
  ||수정자       ||수정일     ||수정내용
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
    <div class="col-lg-9 my-4 mb-4">
        <div name="div_m_top">프린터, 파일저장</div>
        <div name="div_m_search">
            <button id="btn_seacrh">검색</button>
        </div>
        <div name="div_m_table">
            <table class="table">
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
                <tr>
                    <td>4</td>
                    <td>제목입니다.</td>
                    <td>도우너</td>
                    <td>2021.02.22</td>
                    <td>4</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>제목입니다.</td>
                    <td>또치</td>
                    <td>2021.02.22</td>
                    <td>10</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>제목입니다.</td>
                    <td>둘리</td>
                    <td>2021.02.22</td>
                    <td>7</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>제목입니다.</td>
                    <td>희동이</td>
                    <td>2021.02.22</td>
                    <td>0</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="text-center">
            <ul class="pagination">
                <li><a href="#">1</a></li>
            </ul>
        </div>
        <div name="div_m_bottom">
            <button id="btn_addPage">신규 작성</button>
        </div>
    </div>
    <script type="text/javascript" src="/static/js/cccdms/cprcss/cPlanYrMain.js"></script>
    </body>
</html>
