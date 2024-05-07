<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/user.css">
</head>

<body>
	<div class="container">
		<div>
			<label for="title">제목</label> <input type="text"
				value="${board.title }" id="title" name="title" readonly>
		</div>
		<div>
			<label for="author">작성자</label> <input type="text"
				value="${board.id }" id="author" name="author" readonly>
		</div>
		<div>
			<fmt:formatDate value="${board.reg_date}" pattern="yy-MM-dd HH:mm" />
		</div>
		<div>
			<label for="content">내용</label>
			<textarea id="content" name="content" rows="4" cols="60" required> ${board.content } </textarea>
		</div>

		<input type="hidden" name="num" value="${board.num}">


		<c:choose>
			<c:when test="${not empty user}">
				<c:if test="${user.id eq board.id}">
					<button onclick="location.href='/updateBoardAction?num=${board.num}'">수정</button>
					<button onclick="location.href='/deleteBoard?num=${board.num}'">삭제</button>
				</c:if>
			</c:when>
		</c:choose>
	</div>
</body>
</html>