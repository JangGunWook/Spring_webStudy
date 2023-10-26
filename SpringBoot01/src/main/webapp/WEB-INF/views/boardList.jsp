<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록</h1>

	<table border="1">

		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.idx}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.indate}</td>
				<td>
					<img alt="이미지" src="/img/${board.img}">
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="goWrite">작성하기</a>
	
	<img alt="" src="img/">
	<a href="http://localhost:5000/test?name=jang">요청보내기</a>
	
</body>
</html>