<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		// scriptlet
		// Integer.parseInt ==> 자바에서 형변환하는거 
		int num1 = Integer.parseInt(request.getParameter("value1"));
		int num2 = Integer.parseInt(request.getParameter("value2"));
	%>
	<p><%=num1 + num2%></p>
	<p><%=num1 - num2%></p>
	<p><%=num1 * num2%></p>
	<p><%=num1 / num2%></p>
</body>
</html>