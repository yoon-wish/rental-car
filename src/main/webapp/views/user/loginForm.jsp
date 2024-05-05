<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/style/user.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>로그인</h2>
		<form action="/loginAction" method="post">
			<div>
				<label for="id">아이디</label> <input type="text" id="id" name="id">
			</div>
			<div>
				<label for="password">비밀번호</label> 
				<input type="password" id="password" name="password">
			</div>
			<button type="submit">로그인</button>
		</form>
		<div class="divider"></div>
		<div class="register">
			<h3>계정이 없으신가요?</h3>
			<a href="/join">회원가입</a>
		</div>
		
	</div>

	<script src="\resources\script\validation-login.js"></script>
</body>
</html>