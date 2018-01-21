<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="createUser" method="POST">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<label for="id">ID</label>
		<input type="text" name="id"/><br />
		<label for="pwd">PASSWORD</label>
		<input type="password" name="pwd"/><br />
		<label for="name">NAME</label>
		<input type="text" name="name"/><br />
		<label for="email">EMAIL</label>
		<input type="email" name="email"/><br />
		<label for="address">ADDRESS</label>
		<input type="text" name="addr"/><br />
		<label for="auth">AUTHORITY</label>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>