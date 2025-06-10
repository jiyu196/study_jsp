<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<form method= "post" class="container">
		<fieldset>
			<legend class="my-5">회원가입</legend>
			<p><label for="id" class="form-label">아이디</label></p>
			<input name="id" id="id" class="form-control">
			<p><label for="pw" class="form-label"> 비밀번호</label></p>
			<input name="pw" type="password" id="pw" class="form-control">
			<p><label for="name" class="form-label">이름</label></p>
			<input name="name" id="name" class="form-control mb-5">
			<div class="d-grid">
				<button type= "submit" class="btn btn-outline-info btn-block">회원가입</button>
			</div>	
		</fieldset>
	</form>
</body>
</html>