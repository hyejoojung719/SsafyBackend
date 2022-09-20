<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<%@ include file="../include/nav.jsp"%>

	<h1>책 정보 등록</h1>
	<form action="${root}/book" method=post>
		<input type="hidden" name="action" value="regist">
		<div class="mb-3 mt-3">
			<label for="isbn" class="form-label"> 책 번호 : </label> <input
				type="text" class="form-control" id="isbn"
				placeholder="Enter isbn" name="isbn">
		</div>
		<div class="mb-3 mt-3">
			<label for="title" class="form-label"> 책 제목 : </label> <input
				type="text" class="form-control" id="title"
				placeholder="Enter title" name="title">
		</div>
		<div class="mb-3">
			<label for="author" class="form-label">작가 :</label> <input
				type="text" class="form-control" id="author"
				placeholder="Enter author" name="author">
		</div>
		<div class="mb-3">
			<label for="price" class="form-label">가격 :</label> <input
				type="text" class="form-control" id="price"
				placeholder="Enter price" name="price">
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>