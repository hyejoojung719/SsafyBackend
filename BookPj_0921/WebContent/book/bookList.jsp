<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file='../include/header.jsp'%>

<script>
	window.onload = function(){
		let deleteBtns = document.querySelectorAll(".deleteBook")
		
		deleteBtns.forEach(function(el){
			el.addEventListener("click", function(e){
				e.preventDefault();
				let isbn = this.parentNode.parentNode.children[0].innerText;
				
				if(confirm("해당 책정보 삭제하시겠습니까/")){
					location.href="${root}/book?action=delete&isbn="+isbn;
				}
			})
		})
		}
</script>

</head>
<body>
	<%@ include file='../include/nav.jsp'%>

	<div class="container mt-3">
		<h2>책 리스트</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작가</th>
					<th>가격</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="book" items="${list}">
					<tr>
						<td>${book.isbn}</td>
						<td><a href="${root}/book?action=detail&isbn=${book.isbn}">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.price}</td>
						<td><a class="deleteBook">삭제</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

	<%@ include file='../include/footer.jsp'%>
</body>
</html>