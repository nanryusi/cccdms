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
    <h2>연간보육계획안</h2>
    <section class="main">
        <div name="div_m_top">프린터, 파일저장</div>
        <div class="row" name="div_m_search">
            <div class="col-8">
                <input type="text">
            </div>
            <div class="col-4">
                <button class="btn btn-outline-primary" id="btn_seacrh">검색</button>
            </div>
        </div>
        <div class="table-responsive" name="div_m_table">
            <table class="table table-striped table-sm">
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
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="row" name="div_m_bottom">
            <div class="col">
                <button class="btn btn-primary fa-pull-right" id="btn_addPage">신규 작성</button>
            </div>
        </div>
    </section>
    <script type="text/javascript" src="/static/js/cccdms/cprcss/cPlanYrMain.js"></script>
    </body>
</html>
