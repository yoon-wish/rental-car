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

<%
String num = request.getParameter("num");
%>

<body>
	<div class="container">
		<form action="/updateBoardFormAction" method="post" >
			<div>
				<label for="title">제목</label> <input type="text"
					value="${board.title}" id="title" name="title">
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
				<textarea id="content" name="content" rows="4" cols="50"> ${board.content} </textarea>
			</div>
			<input type="hidden" name="num" value="${board.num }">

			<button type='submit'>수정하기</button>
		</form>
	</div>
</body>
</html>