<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<h2>책 등록</h2>
		<form action="/mvc/book" method="get">
			<input type="hidden" name="action" value="bookRegi">
			<div class="mb-3 mt-3">
				<label for="isbn">번호:</label> <input type="text"
					class="form-control" id="isbn" placeholder="Enter isbn"
					name="isbn">
			</div>
			<div class="mb-3">
				<label for="title">책 제목 :</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">
			</div>
			<div class="mb-3 mt-3">
				<label for="author">작가:</label> <input type="text"
					class="form-control" id="author" placeholder="Enter author"
					name="author">
			</div>
			<div class="mb-3">
				<label for="price">가격 :</label> <input type="text"
					class="form-control" id="price" placeholder="Enter price"
					name="price">
			</div>
			<button type="submit" class="btn btn-primary">책 등록</button>
		</form>
	</div>
</body>
</html>