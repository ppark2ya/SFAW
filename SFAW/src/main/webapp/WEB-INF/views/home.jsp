<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<jsp:include page="/inc/resources.jsp"></jsp:include>
<style>
body{
	padding: 15px 15px 0px 15px;
}
#header{
	padding-bottom: 10px;
	border-bottom: 1px solid #000;
}
#logo{
	display: inline-block;
}
#nav{
	padding-top: 30px;
	float: right;
}
#nav ul li{
	float:left;
	list-style: none;
}
#nav ul li a{
	text-decoration: none;
	color: #000;
	font-size: 20px;
	padding-left: 15px;
}
#nav ul li a:hover{
	font-weight: bold;
}
</style>
<title>Search For Awesome Wear!!</title>
</head>
<body ng-app="SFAW_APP">
	<div class="container-fluid">
		<header id="header">
			<div id="logo">
				<a href="#/">
					<img src="/resources/images/logo.PNG" alt="logo" />
				</a>
			</div>
			<div id="nav">
				<ul>
					<li><a href="#/user/signin">LOGIN</a></li>
					<li><a href="#/user/signup">JOIN</a></li>
					<li><a href="">CART</a></li>
					<li><a href="">MY PAGE</a></li>
					<li><a href="">SEARCH</a></li>
				</ul>
			</div>
		</header>
		<ng-view></ng-view>
	</div>
</body>
</html>