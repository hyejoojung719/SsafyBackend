<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty sessionScope.userInfo}">
					<li class="nav-item"><a class="nav-link"
						href="${root}/user?action=goSignIn">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${root}/user?action=goSignup">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="${root}/user?action=signOut">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
			<li class="nav-item"><a class="nav-link"
				href="${root}/book?action=list">책 목록</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${root}/book?action=goRegist">책 등록</a></li>
		</ul>
	</div>
</nav>