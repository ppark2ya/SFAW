<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/inc/resources.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<h1>home!</h1>
	<a href="/user/signin">로그인페이지</a>
	<a href="/user/signup">회원가입페이지</a>
	<c:if test="${ empty sessionScope }">asd</c:if>
</body>
</html>