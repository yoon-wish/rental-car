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

	<div class='allCar'>
		<c:forEach var="carList" items="${carList }" varStatus="loop">
		<div class='car-item'>
			<h3>${index }</h3>
			
			<div>
				
					<img src="${carList.car_img }">
				
			</div>
			
			<div class="car-details">
				
				<h2>${carList.car_brand } ${carList.car_name }</h2>
				<p>${carList.year }년형|${carList.fuel }</p>
			
			<div>
				<p>${reservationList[loop.index].rent_start} ~ ${reservationList[loop.index].rent_end}			
				(총 ${reservationList[loop.index].rent_period}일)</p>
				<p>결제금액 | <fmt:formatNumber value="${carList.price * reservationList[loop.index].rent_period }" pattern="#,###" />원</p>
				<p>${reservationList[loop.index].status}</p>
				
				
			</div>

                <form action = "/cancelReservation" method="POST">
                        <input type='hidden' name='id' value="${id }">
						<input type='hidden' name='start' value="${reservationList[loop.index].rent_start }">
						<input type='hidden' name='end' value="${reservationList[loop.index].rent_end }">
                    	<input type='hidden' name='car_num' value="${reservationList[loop.index].car_num }">
                    	<input type='submit' value="취소하기">
                </form>
                <!-- 수정하기 버튼 -->
                <button onclick="toggleReservationForm(${loop.index})">변경하기</button>
                
                <!-- 예약 수정 폼 -->
                    <form action="/updateReservation" method="POST">
                <div id="reservationForm${loop.index}" style="display: none;">
                    <label for="start${loop.index }">대여일 </label>
                    <input type="date" id="start${loop.index }" name="start-new"><br>
                    <label for="end${loop.index }">반납일 </label>
                    <input type="date" id="end${loop.index }" name="end-new"><br>
                    
	
                    	<input type='hidden' name='id' value="${id }">
						<input type='hidden' name='start' value="${reservationList[loop.index].rent_start }">
						<input type='hidden' name='end' value="${reservationList[loop.index].rent_end }">
                    	<input type='hidden' name='car_num' value="${reservationList[loop.index].car_num }">
                    	<input type='submit' value="제출">
                </div>
                	</form>
		</div>
		</div>
		</c:forEach>	
		</div>
	</div>
	<script src="\resources\script\validation-car.js"></script>
</body>
</html>