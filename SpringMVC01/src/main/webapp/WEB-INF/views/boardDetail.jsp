<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>SpringMVC01</h1>
			<p>스프링을 활용한 게시판 만들기</p>
		</div>

		<h2>Card Header and Footer</h2>
		<div class="card">
			<div class="card-header">게시판</div>
			<div class="card-body">

				<form action="update" method=post>
					<input id="idx" type="hidden" name="idx" value="${detail.idx}">
					<input id="count" type="hidden" name="count" value="${detail.count}">
				
					<div class="form-group">
						<label for="title">Title:</label> 
						<input value="${detail.title}" name = "title" type="text" class="form-control" placeholder="Enter title" id="title">
					</div>
					<div class="form-group">
						<label for="writer">Writer:</label>
						 <input value="${detail.writer}" name="writer" type="text" class="form-control" placeholder="Enter writer" id="writer">
					</div>
					<div class="form-group">
						<label for="content">Content:</label>
						 <textarea rows="10" name="content" class="form-control" placeholder="Enter content" id="content">${detail.content}</textarea>
					</div>
					<button type="submit" class="btn btn-primary">수정하기</button>
					<a id="count" class="btn btn-primary" href="list">목록으로 이동</a>
				</form>

			</div>
			<div class="card-footer">인공지능 융합 서비스 개발자과정 안현진</div>
		</div>

	</div>
	
	<script src="resources/js/count.js"></script>
</body>
</html>
