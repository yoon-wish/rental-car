<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/home.css">
<meta charset="UTF-8">
</head>
<body>
	<div class='container'>

		<div class='car-date'>
			<label for="start">대여일</label> <input type="date" id="start"
				name="start"> <label for="end">반납일</label> <input
				type="date" id="end" name="end">
		</div>

		<div class='allCar'>
			<c:forEach var="car" items="${carList}">
				<div class='car-item'>
				
					<a href="/readCarAction?car_num=${car.car_num}"> 
					<img src='${car.car_img }'>
					</a>
					
					<h4>${car.car_brand}${car.car_name }</h4>
					<h3 id='price'>${car.price }</h3>
					<p>${car.year}년식|${car.fuel}</p>
					<input type="hidden" value=${car.car_num }>
				</div>
				<script src="\resources\script\validation-home.js"></script>
			</c:forEach>
		</div>

		<div class='paging'>
			<c:choose>
				<c:when test="${carSize % 6 == 0}">
					<c:set var="iterations" value="${carSize / 6}" />
					<c:forEach var="index" begin="1" end="${iterations}">
						<button name="page" onclick="location.href='/main?page=${index}'">${index }</button>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:set var="iterations" value="${carSize / 6 + 1}" />
					<c:forEach var="index" begin="1" end="${iterations}">
						<button name="page" onclick="location.href='/main?page=${index}'">${index }</button>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>