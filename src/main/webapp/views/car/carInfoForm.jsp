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
<body>
	<div class="container">

		<form action="/reserveCarAction" method="POST">

			<div>
				<img src="${car.car_img }">
			</div>


			<div class="car-details">

				<h2>${car.car_brand }${car.car_name }</h2>

				<h2>${car.price }</h2>

				<p>${car.size }</p>

				<p>${car.year }년형|${car.fuel }</p>

				<p>${car.limit_age }세이상| 면허 취득 ${car.limit_period }년 이상</p>
	
				<input type="hidden" id="car_num" name="car_num" value="${car.car_num }">

				<div class='car-reservation'>
					<label for="start">대여일</label> <input type="date" id="start"
						name="start"> <label for="end">반납일</label> <input
						type="date" id="end" name="end">
				</div>
			</div>

			<c:choose>
				<c:when test="${not empty user }">
					<input type='submit' value="예약하기">
				</c:when>

			</c:choose>
		</form>
	</div>
	<script src="\resources\script\validation-home.js"></script>

</body>
</html>