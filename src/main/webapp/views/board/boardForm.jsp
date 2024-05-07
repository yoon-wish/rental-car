<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/board.css">
</head>
<body>
 <div class="container">
    <h2>게시판 목록</h2>
	<div class="board-form">
		<table class = "board-table">
			<thead>
				<tr>
					<th>글 번 호</th>
					<th>제 목</th>
					<th>글 쓴 이</th>
					<th>작성시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.num}</td>
						<td><a href="/readAction?num=${board.num}">${board.title}</a></td>
						<td>${board.id}</td>
						<td> <fmt:formatDate value="${board.reg_date}" pattern="yy-MM-dd HH:mm" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<button type="submit" onclick="window.location.href='/write'">작성</button>
	
</div>
</body>
</html>