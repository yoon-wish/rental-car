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
	
	<div class="container">
	
		<c:forEach var="carList" items="${carList }" varStatus="loop">
			<h3>${index }</h3>
			
			<div>
				<img src="${carList.car_img }">
			</div>
			
			<div class="car-details">
				
				<h2>${carList.car_brand } ${carList.car_name }</h2>
				<p>${carList.year }년형|${carList.fuel }</p>
			
			</div>
			
			<div>
				<p>${reservationList[loop.index].rent_start}</p>				
				<p>${reservationList[loop.index].rent_end}</p>				
				<p>총 ${reservationList[loop.index].rent_period}일</p>
				<p> ${carList.price * reservationList[loop.index].rent_period } </p>
							
			</div>
		
		</c:forEach>	
	</div>
	
</body>
</html>