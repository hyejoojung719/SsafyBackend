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
	<div class="container mt-3">
  <h2>
  	<% Book book = (Book)request.getAttribute("book");%>
  </h2>
  <div class="card">
  	<div class="card-header">제목
    	<%= book.getTitle() %>
    </div>
    <div class="card-header">작가 
    	<%= book.getAuthor() %>
    </div>
    <div class="card-header">가격
    	<%= book.getPrice() %>
    </div> 
  </div>
</div>
</body>
</html>