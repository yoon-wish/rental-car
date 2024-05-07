<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/user.css">
</head>
<body>
 <div class="container">
    <form action="writeAction" method="post">
        <div>
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div>
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="4" cols="50" required></textarea>
        </div>
        <button type="submit">작성하기</button>
    </form>
</div>
</body>
</html>