<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/car.css">
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>면허 취득 ${car.limit_period }년 이상 이용가능합니다.</h1>
	</div>
	<div class="button-container">
		<button onclick="window.location.href='/main?page=1'" >홈으로</button>
	</div>
</body>
</html>