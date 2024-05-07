<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<link rel="icon"
	href="https://cdn-icons-png.flaticon.com/128/6015/6015831.png">
<link rel="stylesheet" href="/resources/style/header.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<title>WISH RENTAL CAR</title>
</head>
<body>
	<header>

		<div id='container'>
			<div id='sub-head'>
			<c:choose>
				<c:when test="${not empty user }">
					<button onclick="location.href='/logout'">로그아웃</button>
				</c:when>
				<c:otherwise>
					<button onclick="location.href='/login'">로그인</button>
				</c:otherwise>
			</c:choose>
			</div>


			<div id='title'>
				<a href='/home'>WISH RENTAL CAR</a>
			</div>

			<nav class="nav">
				<a href="/home" class="nav-item" active-color='#526D82'>차량목록</a> <a
					href="#" class="nav-item" active-color='#526D82'>공지사항</a> <a
					href="/boardAction" class="nav-item" active-color='#526D82'>게시판</a> <a
					href="/myPage" class="nav-item" active-color='#526D82'>마이페이지</a> <span
					class="nav-indicator"></span>
			</nav>

		</div>

	</header>
	<script src="\resources\script\validation-header.js"></script>
</body>
</html>