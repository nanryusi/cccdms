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
          <a href="index.html" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
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
            <li><a href="index.html">Homepage</a></li>
            <li><a href="generic.html">Generic</a></li>
            <li><a href="elements.html">Elements</a></li>
            <li>
              <span class="opener">Submenu</span>
              <ul>
                <li><a href="#">Lorem Dolor</a></li>
                <li><a href="#">Ipsum Adipiscing</a></li>
                <li><a href="#">Tempus Magna</a></li>
                <li><a href="#">Feugiat Veroeros</a></li>
              </ul>
            </li>
            <li><a href="#">Etiam Dolore</a></li>
            <li><a href="#">Adipiscing</a></li>
            <li>
              <span class="opener">Another Submenu</span>
              <ul>
                <li><a href="#">Lorem Dolor</a></li>
                <li><a href="#">Ipsum Adipiscing</a></li>
                <li><a href="#">Tempus Magna</a></li>
                <li><a href="#">Feugiat Veroeros</a></li>
              </ul>
            </li>
            <li><a href="#">Maximus Erat</a></li>
            <li><a href="#">Sapien Mauris</a></li>
            <li><a href="#">Amet Lacinia</a></li>
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
