<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calc_result.jsp" method="post">
		<input name= "value1">
		<input name= "value2">
		<button>전송</button>
		<button formaction= "calcServ">서블릿으로</button>
	</form>
	
</body>
</html>