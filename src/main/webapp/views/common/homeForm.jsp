<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/home.css">
<meta charset="UTF-8">
</head>
<body>
	<div class='container'>
		<form action='/main'>
			<div class='car-date'>
				<label for="start">대여일</label> 
				<input type="date" id="start"name="start"> 
				<label for="end">반납일</label> 
				<input type="date" id="end" name="end">
				
				<input type='hidden' name="page" value="1">
				<input type='submit' value="조회" onclick="saveDate()">
				
			</div>
		</form>
		
		<div class='allCar'>
			<c:forEach var="car" items="${carList}">
				<div class='car-item'>

					<a href="/readCarAction?car_num=${car.car_num}"> <img
						src='${car.car_img }'>
					</a>

					<h4>${car.car_brand} ${car.car_name }</h4>
					<h3 id='price'><fmt:formatNumber value="${car.price }" pattern="#,###" /></h3>
					<p>${car.year}년식|${car.fuel}</p>
					<p>${car.limit_age}살이상| 면허취득 ${car.limit_period}년 이상</p>
					<input type="hidden" value=${car.car_num }>
				</div>

			</c:forEach>
		</div>

		<div class='paging'>
			<c:choose>
				<c:when test="${carSize % 6 == 0}">
					<c:set var="iterations" value="${carSize / 6}" />
					<c:forEach var="index" begin="1" end="${iterations}">					
 							<button name="page" onclick="moveToPage(${index})">${index}</button>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:set var="iterations" value="${carSize / 6 + 1}" />
					<c:forEach var="index" begin="1" end="${iterations}">
							<button name="page" onclick="moveToPage(${index})">${index}</button>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<script src="\resources\script\validation-home.js"></script>
</body>
</html>