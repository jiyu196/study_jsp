<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(exception.getClass() == ArithmeticException.class) {
		out.println("<h3>숫자를 0으로 나눌 수 없습니다</h3>");
	}
	else if(exception.getClass() == NumberFormatException.class) {
		out.println("<h3>올바른 메세지를 입력하세요</h3>");
	}
	else {
		out.println("<h3>처리하지 못한 에러</h3>");
	}
%>
</body>
</html>