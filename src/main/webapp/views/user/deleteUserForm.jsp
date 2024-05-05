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
		<h2>탈퇴하기</h2>
		<form action="/deleteAction" method="post">
			<div>
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password">
			</div>
			<button type="submit">탈퇴하기</button>
		</form>
		<div class="divider"></div>


	</div>

	<script src="\resources\script\validation-login.js"></script>
</body>
</html>