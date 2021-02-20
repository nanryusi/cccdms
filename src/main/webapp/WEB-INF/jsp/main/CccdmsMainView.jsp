<%--
  Created by ryusi
  Date: 2021-02-06
  Description : 메인화면
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8" http-equiv="Content-Language" name="viewport" content="ko, width=device-width, initial-scale=1, user-scalable=no" />
  <title>Editorial by HTML5 UP</title>
  <link href="<c:url value='/'/>css/main.css" rel="stylesheet" type="text/css" >
</head>
<body class="is-preload">
<noscript>자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
  <!-- Wrapper -->
  <div id="wrapper">

    <!-- Main -->
    <div id="main">
      <div class="inner">

        <!-- Header -->
        <header id="header">
          <a href="index.html" class="logo"><strong>확인용</strong> by HTML5 UP</a>
          <ul class="icons">
            <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
            <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
          </ul>
        </header>

        <!-- Banner -->
        <section id="banner">
          <div class="content">
            <header>
              <h1>Hi, I’m Editorial<br />
                by HTML5 UP</h1>
              <p>A free and fully responsive site template</p>
            </header>
            <p>Aenean ornare velit lacus, ac varius enim ullamcorper eu. Proin aliquam facilisis ante interdum congue. Integer mollis, nisl amet convallis, porttitor magna ullamcorper, amet egestas mauris. Ut magna finibus nisi nec lacinia. Nam maximus erat id euismod egestas. Pellentesque sapien ac quam. Lorem ipsum dolor sit nullam.</p>
            <ul class="actions">
              <li><a href="#" class="button big">Learn More</a></li>
            </ul>
          </div>
          <span class="image object">
                      <img src="<c:url value='/images/pic10.jpg' />" alt="" />
                    </span>
        </section>

        <!-- Section -->
        <section>
          <header class="major">
            <h2>Erat lacinia</h2>
          </header>
          <div class="features">
            <article>
              <span class="icon fa-gem"></span>
              <div class="content">
                <h3>Portitor ullamcorper</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
              </div>
            </article>
            <article>
              <span class="icon solid fa-paper-plane"></span>
              <div class="content">
                <h3>Sapien veroeros</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
              </div>
            </article>
            <article>
              <span class="icon solid fa-rocket"></span>
              <div class="content">
                <h3>Quam lorem ipsum</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
              </div>
            </article>
            <article>
              <span class="icon solid fa-signal"></span>
              <div class="content">
                <h3>Sed magna finibus</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
              </div>
            </article>
          </div>
        </section>


      </div>
    </div>

    <!-- Sidebar -->
    <div id="sidebar">
      <div class="inner">

        <!-- Search -->
        <section id="search" class="alt">
          <form method="post" action="#">
            <input type="text" name="query" id="query" placeholder="Search" />
          </form>
        </section>

        <!-- Menu -->
        <nav id="menu">
          <header class="major">
            <h2>Menu</h2>
          </header>
          <ul>
            <li>
              <span class="opener">보육과정 및 상호작용</span>
              <ul>
                <li><a href="#">연간보육계획안</a></li>
                <li><a href="#">월간, 주간보육계획안</a></li>
                <li><a href="#">일일보육계획안 및 보육일지</a></li>
                <li><a href="#">특별활동동의서(부모대상)</a></li>
                <li><a href="#">운영위원회 회의록(부모공개)</a></li>
                <li><a href="#">관찰일지</a></li>
                <li><a href="#">영유아 발달평가</a></li>
                <li><a href="#">*(장애) 개별화 보육계획안 및 보육일지</a></li>
                <li><a href="#">*(장애) 치료일지 또는 개별화 보육일지</a></li>
              </ul>
            </li>
            <li>
              <span class="opener">보육환경 및 운영관리</span>
              <ul>
                <li><a href="#">운영계획을 위한 수요조사(부모대상)</a></li>
                <li><a href="#">어린이집 운영계획서</a></li>
                <li><a href="#">운영일지</a></li>
                <li><a href="#">신입원아 적응 일지</a></li>
                <li><a href="#">부모교육 (부모대상)</a></li>
                <li><a href="#">가정통신문(부모대상)</a></li>
                <li><a href="#">부모면담일지</a></li>
                <li><a href="#">부모 만족도조사(부모대상)</a></li>
                <li><a href="#">지역사회 연계활동</a></li>
              </ul>
            </li>
            <li>
              <span class="opener">건강, 안전</span>
              <ul>
                <li><a href="#">실내 공기질 측정 관리 기록</a></li>
                <li><a href="#">식단표 및 제공기록(부모공개)</a></li>
                <li><a href="#">알레르기질환 조사서 및 지침서(부모대상)</a></li>
                <li><a href="#">투약의뢰서(부모대상)</a></li>
                <li><a href="#">건강검진기간 알림 서류</a></li>
                <li><a href="#">응급처치동의서(부모대상)</a></li>
                <li><a href="#">귀가동의서(부모대상)</a></li>
                <li><a href="#">차량안전검점표</a></li>
                <li><a href="#">소방대피훈련일지</a></li>
                <li><a href="#">영유아 안전교육 일지</a></li>
                <li><a href="#">비상시 업무분장표</a></li>
              </ul>
            </li>
            <li>
              <span class="opener">교직원</span>
              <ul>
                <li><a href="#">교사회의록</a></li>
                <li><a href="#">업무분장표</a></li>
                <li><a href="#">교직원 개별면담</a></li>
                <li><a href="#">교직원 복지향상</a></li>
                <li><a href="#">교직원 교육 연간계획안</a></li>
                <li><a href="#">직원교육 관리 대장</a></li>
                <li><a href="#">연수보고서</a></li>
                <li><a href="#">교직원 상호작용 지원 관찰 기록지</a></li>
                <li><a href="#">근무평가서</a></li>
              </ul>
            </li>
            <li>
              <span class="opener">정보제공</span>
              <ul>
                <li><a href="#">신규 직원 오리엔테이션 자료</a></li>
                <li><a href="#">신입 원아 부모 오리엔테이션 자료</a></li>
                <li><a href="#">보육실 개방 및 참관 안내문</a></li>
                <li><a href="#">지역사회 전문기관 정보</a></li>
                <li><a href="#">감염병 관리수칙</a></li>
                <li><a href="#">차량안전수칙</a></li>
                <li><a href="#">비상시 대처방안</a></li>
                <li><a href="#">영유아 학대 예방 지침</a></li>
                <li><a href="#">근로계약서(예시)</a></li>
                <li><a href="#">취업규칙-복무규정(예시)</a></li>
              </ul>
            </li>
          </ul>
        </nav>

        <!-- Section -->
        <section>
          <header class="major">
            <h2>Ante interdum</h2>
          </header>
          <div class="mini-posts">
            <article>
              <a href="#" class="image"><img src="<c:url value='/images/pic07.jpg' />" alt="" /></a>
              <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
            </article>
            <article>
              <a href="#" class="image"><img src="<c:url value='/images/pic08.jpg' />" alt="" /></a>
              <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
            </article>
            <article>
              <a href="#" class="image"><img src="<c:url value='/images/pic09.jpg' />" alt="" /></a>
              <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
            </article>
          </div>
          <ul class="actions">
            <li><a href="#" class="button">More</a></li>
          </ul>
        </section>

        <!-- Section -->
        <section>
          <header class="major">
            <h2>Get in touch</h2>
          </header>
          <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
          <ul class="contact">
            <li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
            <li class="icon solid fa-phone">(000) 000-0000</li>
            <li class="icon solid fa-home">1234 Somewhere Road #8254<br />
              Nashville, TN 00000-0000</li>
          </ul>
        </section>

        <!-- Footer -->
        <footer id="footer">
          <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
        </footer>

      </div>
    </div>

  </div>

<script type="text/javascript" src="<c:url value='/js/jquery.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/browser.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/breakpoints.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/util.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/main.js' />"></script>
</body>
</html>
