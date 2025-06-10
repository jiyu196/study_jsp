<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이건 JSP로 호출</h2>
	<h2>이건 JSP로 수정</h2>
	<% String name = "새똥이"; %>
	<%
	for(int i = 1 ; i <= 10 ; i++) {
		out.println("<p>" + i);
	}
	%>
	<h3><%=name%></h3>
</body>
</html>