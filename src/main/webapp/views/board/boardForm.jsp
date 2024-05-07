<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/board.css">
</head>
<body>
	<div class="container">
		<h2>자유게시판</h2>
		<div class="board-form">
			<table class="board-table">
				<colgroup>
					<col width="25%" />
					<col width="15%" />
					<col width="20%" />
				</colgroup>
				<thead>
					<tr>
						<th>제 목</th>
						<th>글 쓴 이</th>
						<th>작성시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td><a href="/readAction?num=${board.num}">${board.title}</a></td>
							<td>${board.id}</td>
							<td><fmt:formatDate value="${board.reg_date}"
									pattern="yy-MM-dd HH:mm" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<c:choose>
			<c:when test="${not empty user}">
				<c:if test="${user.admin eq 'N'}">
					<button type="submit" onclick="window.location.href='/write'">작성</button>
				</c:if>
			</c:when>
		</c:choose>

	</div>
</body>
</html>