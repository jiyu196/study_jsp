<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="domain.Member" />
<jsp:setProperty name="member" property="id"  value="10"/>
<%
	Object o = pageContext.getAttribute("member");
	Member member2 = (Member) o;
	
%>
<h3><%= member2.getId() %></h3>
<h3>${member.id}</h3>
<h3>${member.getId()}</h3>
<h3>${member.test}</h3>
<%@ include file="er1.jsp" %>
<jsp:include page="er1.jsp" />
<jsp:forward page="directive.jsp"/>
</body>
</html>