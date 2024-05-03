<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/style/user.css">
</head>
<body>
    <div class="container">
        <h2>회원가입</h2>
        <form action="/home" method="post">
            <div>
                <label for="username">아이디</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div>
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div>
                <label for="name">이름</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div>
                <label for="age">나이</label>
                <input type="text" id="age" name="age" required>
            </div>
            <div>
                <label for="carrier">통신사</label>
                <select id="carrier" name="carrier" required>
                    <option value="">통신사 선택</option>
                    <option value="skt">SKT</option>
                    <option value="kt">KT</option>
                    <option value="lgt">LG U+</option>
                </select>
            </div>
            <div>
                <label for="phone">휴대폰 번호</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="radio-container">
                <input type="radio" id="license_yes" name="license" value="yes">
                <label for="license_yes">보유</label>
                <input type="radio" id="license_no" name="license" value="no">
                <label for="license_no">미보유</label>
            </div>
            <div id="license-year-container" style="display: none;">
                <label for="license_year">면허증 취득 년도</label>
                <input type="number" id="license_year" name="license_year" min="1915" max="2024">
            </div>
            <div class="radio-container">
                <input type="radio" id="admin_yes" name="admin" value="yes">
                <label for="admin_yes">관리자</label>
                <input type="radio" id="admin_no" name="admin" value="no">
                <label for="admin_no">일반회원</label>
            </div>
            <div id="admin-password-container" style="display: none;">
                <label for="admin_password">관리자 암호</label>
                <input type="password" id="admin_password" name="admin_password">
            </div>
            <div class="checkbox-container">
                <input type="checkbox" id="agree" name="agree" required>
                <label for="agree">약관에 동의합니다.</label>
            </div>
            <button type="submit">가입하기</button>
        </form>
    </div>

    <script src="\resources\script\validation-user.js"></script>
</body>
</html>