<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/car.css">
</head>
<body>
<div class="car-info-container">

    <div class="car-image">
        <img src="car_image.jpg" alt="차 이미지" width="200" height="150">
    </div>


    <div class="car-details">

        <h2>차 이름: 차 모델명</h2>


        <p>브랜드: 차 브랜드</p>

        <p>사이즈: 차 크기</p>

        <p>차종: 국내차</p>

        <p>년도: 2024년식</p>

        <p>연료: 가솔린</p>

        <p>나이 제한: 21세 이상</p>

        <p>면허 취득 기한: 2022년 12월 31일까지</p>
    </div>
</div>
</body>
</html>