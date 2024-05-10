<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/header" />
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/user.css">
</head>
<body>

	<div class="container">
		<div id=buttonSet>
			<button type="submit" onclick="window.location.href='/myPage'">내정보</button>
			<button type="submit" onclick="window.location.href='/reserveListAction?id=${user.id }'">예약내역</button>
		</div>
	</div>
</body>
</html>