<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/header" />
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/user.css">
</head>
<body>
	<c:if test="${empty user  }">
		<c:redirect url="/login" />
	</c:if>

	<div class="container">
		<h2>마이페이지 - 수정</h2>
		<form action="/updateAction" method="post">
			<div>
				<label for="id">아이디</label> <input type="text" id="id" name="id"
					value="${user.id }" readonly>
			</div>

			<div>
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password">
			</div>

			<div>
				<label for="new-password">변경할 비밀번호</label> 
				<input type="password" id="new-password" name="new-password">
			</div>

			<div>
				<label for="email">이메일</label> <input type="email" id="email"
					name="email" value="${user.email }">
			</div>


			<div>
				<label for="name">이름</label> <input type="text" id="name"
					name="name" value="${user.name }" readonly>
			</div>



			<div>
				<label for="birth">생년월일</label> <input type="date" id="birth"
					name="birth" value="${user.birth }" readonly>
			</div>

			<div>
				<label for="telecom">통신사</label> <select id="telecom" name="telecom">
					<option selected>통신사 선택</option>
					<option value="skt" ${user.telecom eq 'skt' ? 'selected' : ''}>SKT</option>
					<option value="kt" ${user.telecom eq 'kt' ? 'selected' : ''}>KT</option>
					<option value="lgt" ${user.telecom eq 'lgt' ? 'selected' : ''}>LGU+</option>
				</select>
			</div>

			<div>
				<label for="phone">휴대폰 번호</label> <input type="text" id="phone"
					name="phone" value="${user.phone }">
			</div>


			<label for="license">면허증</label>
			<div class="radio-container">
				<input type="radio" id="license_yes" name="license" value="Y"
					${user.license eq 'Y' ? 'checked' : '' }> <label
					for="license_yes">보유</label> <input type="radio" id="license_no"
					name="license" value="N" ${user.license eq 'N' ? 'checked' : '' } >
				<label for="license_no">미보유</label>
			</div>


			<div id="license-year-container" style="display: none;">
				<label for="license_date">면허증 취득년도</label> <input type=date
					id="license_date" name="license_date" value="${user.license_date }">
			</div>


			<button type='submit'>수정하기</button>
		</form>

	</div>
<script src="\resources\script\validation-license.js"></script>
</body>
</html>