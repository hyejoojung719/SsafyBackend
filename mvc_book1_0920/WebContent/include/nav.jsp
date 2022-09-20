<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 메뉴바 관련 태그 -->
<nav class="navbar navbar-expand-sm bg-light">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="${root}/book?action=list">책 목록</a></li>
			<li class="nav-item"><a class="nav-link" href="${root}/book?action=goRegistPage">책 정보 등록</a></li>
		</ul>

		<c:choose>
			<%-- session에 userInfo 객체가 없는 경우(로그인 X) --%>
			<c:when test="${empty sessionScope.userInfo}">
			<%-- userInfo는 내가 설정하는 부분 --%>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
				</ul>
			</c:when>
			<%-- 로그인 한 경우 --%>
			<c:otherwise>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" href="#">회원정보 조회</a></li>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>
</nav>