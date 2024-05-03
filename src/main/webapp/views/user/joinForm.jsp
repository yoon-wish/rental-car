<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/style/user.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>회원가입</h2>
        <form action="/home" method="post">
            <div>
                <label for="id">아이디</label>
                <input type="text" id="id" name="id">
            </div>
            
            <p class="error-msg" id="error-msg-id">* 아이디: 필수 정보입니다.</p>
            
            <div>
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password">
            </div>
            
            <p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
            
            <div>
                <label for="email">이메일</label>
                <input type="email" id="email" name="email">
            </div>
            
            <p class="error-msg" id="error-msg-email">* 이메일: 필수 정보입니다.</p>
            
            <div>
                <label for="name">이름</label>
                <input type="text" id="name" name="name">
            </div>
            
            <p class="error-msg" id="error-msg-name">* 이름: 필수 정보입니다.</p>
            
            
            <div>
                <label for="age">나이</label>
                <input type="text" id="age" name="age">
            </div>
            
            <p class="error-msg" id="error-msg-age">* 나이: 필수 정보입니다.</p>
            
            <div>
                <label for="telecom">통신사</label>
                <select id="telecom" name="telecom">
                    <option selected disabled>통신사 선택</option>
                    <option value="skt">SKT</option>
                    <option value="kt">KT</option>
                    <option value="lgt">LG U+</option>
                </select>
            </div>
            
            <p class="error-msg" id="error-msg-telecom">* 통신사: 필수 정보입니다.</p>
            
            <div>
                <label for="phone">휴대폰 번호</label>
                <input type="text" id="phone" name="phone">
            </div>
            
            <p class="error-msg" id="error-msg-phone">* 휴대폰번호: 필수 정보입니다.</p>
            
            <div class="radio-container">
                <input type="radio" id="license_yes" name="license" value="yes">
                <label for="license_yes">보유</label>
                <input type="radio" id="license_no" name="license" value="no">
                <label for="license_no">미보유</label>
            </div>
            
            <p class="error-msg" id="error-msg-license">* 면허취득여부: 필수 정보입니다.</p>
            
            <div id="license-year-container" style="display: none;">
                <label for="license_year">면허증 취득년도</label>
                <input type="number" id="license_year" name="license_year" min="1915" max="2024">
            </div>
            
            <div class="radio-container">
                <input type="radio" id="admin_yes" name="admin" value="yes">
                <label for="admin_yes">관리자</label>
                <input type="radio" id="admin_no" name="admin" value="no" checked>
                <label for="admin_no">일반회원</label>
            </div>
            
            <div id="admin-password-container" style="display: none;">
                <label for="admin_password">관리자 암호</label>
                <input type="password" id="admin_password" name="admin_password">
            </div>
            <div class="checkbox-container">
                <input type="checkbox" id="agree" name="agree">
                <label for="agree">약관에 동의합니다.</label>
            </div>
            
            <p class="error-msg" id="error-msg-agree">* 약관동의 후 가입이 가능합니다.</p>
            
            <button type="submit">가입하기</button>
        </form>
    </div>

    <script src="\resources\script\validation-join.js"></script>
</body>
</html>