<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<% if(session.getAttribute("member") == null) { %>
	<p><a href="signup">회원가입</a></P>
	<p><a href="signin">로그인</a></P> 
	<% } else { %>
	<p>${member.name}님 환영합니다</p>
	<p><a href="signout">로그아웃</a></p>
	<% } %>
</body>
</html>