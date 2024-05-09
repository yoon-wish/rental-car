<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/home.css">
</head>
<body>
	<div class='container'>
		<div class='allCar'>
			<c:forEach var="car" items="${carList}">
				<div class='car-item'>

					<a href="/readCarAction?car_num=${car.car_num}"> <img
						src='${car.car_img }'>
					</a>

					<h4>${car.car_brand} ${car.car_name }</h4>
					<h3 id='price'><fmt:formatNumber value="${car.price }" pattern="#,###" /></h3>
					<p>${car.year}년식|${car.fuel}</p>
					<p>${car.limit_age}살이상|면허취득 ${car.limit_period}년 이상</p>
					<input type="hidden" value=${car.car_num }>
				</div>

			</c:forEach>
		</div>
	</div>
</body>
</html>