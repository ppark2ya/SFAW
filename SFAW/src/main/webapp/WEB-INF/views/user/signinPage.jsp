<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
${errMsg }
	<form action="/user/signin" method="POST">
		<!--
			HTTP Status 403 - Invalid CSRF Token 'null' was found
			on the request parameter '_csrf' or header 'X-CSRF-TOKEN' 해결책
		-->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<label for="uid">id</label>
		<input type="text" name="id"/>
		<label for="pwd">Password</label>
		<input type="password" name="pwd" />
		<button type="submit">confirm</button>
	</form>
</body>
</html>