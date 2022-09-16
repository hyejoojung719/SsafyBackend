<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.ssafy.dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>책 목록 화면</h1>

	<div class="container mt-3">
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작가</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Book> bookList = (List<Book>) request.getAttribute("bookList"); //위에 import 하기
					for (Book book : bookList) {
						out.println("<tr>");
						out.println("<td>" + book.getIsbn() + "</td>");
						out.println("<td><a href='/mvc/book?action=bookDetail&isbn="+book.getIsbn()+"'>" + book.getTitle() + "</a></td>");
						
						out.println("<td>" + book.getAuthor() + "</td>");
						out.println("<td>" + book.getPrice() + "</td>");
						out.println("</tr>");
					}
				%>
			</tbody>
		</table>
	</div>
	
</body>
</html>