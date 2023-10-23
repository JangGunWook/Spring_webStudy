<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>SpringMVC01</h1>
			<p>스프링을 활용한 게시판 만들기</p>
		</div>

		<h2>주요내용</h2>
		<div class="card">
			<div class="card-header">게시판</div>
			<div class="card-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td colspan="4"><input class="form-control" type="text"
								id="search"></td>
							<td>
								<button class="btn btn-primary" id="searchBtn">검색</button>
							</td>
						</tr>
						<tr>
							<td>글 번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성시간</td>
							<td>조회 수</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${boardList}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td><a href="detail?idx=${item.idx}">${item.title}</a></td>
								<td>${item.writer}</td>
								<td>${item.indate}</td>
								<td>${item.count}</td>
								<td><a class="btn btn-primary"
									href="delete?idx=${item.idx}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<a href="goWrite" class="btn btn-success">게시글 작성하기</a>
				<button id="chartBtn" class="btn btn-warning">순위보기</button>
			</div>

			<!-- 페이징 버튼을 표시할 영역 -->
			<div id="pagination" class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
				<!-- 여기에 페이지 버튼이 표시될 것입니다. -->
			</div>

			<div class="card-footer">인공지능 융합 서비스 개발자과정 안현진</div>
		</div>

		<div class="card" id="chartDiv" style="display: none">
			<div class="card-body"></div>
		</div>

	</div>
	<script src="resources/js/list.js"></script>
	<script src="resources/js/pageing.js"></script>
	<script
</body>
</html>
