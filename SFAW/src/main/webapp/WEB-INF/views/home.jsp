<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html ng-app="SFAW_APP">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<base href="/sfaw" />
<link rel="import" href="/inc/resources.html" />
<title>Search For Awesome Wear!!</title>
</head>
<body>
	<div class="container-fluid">
		<header id="header">
			<div id="logo">
				<a href="/">
					<img src="/resources/images/logo.PNG" alt="logo" />
				</a>
			</div>
			<div id="nav">
				<ul>
					<li><a href="user/signin">LOGIN</a></li>
					<li><a href="user/signup">JOIN</a></li>
					<li><a href="">CART</a></li>
					<li><a href="">MY PAGE</a></li>
					<li><a href="">SEARCH</a></li>
				</ul>
			</div>
		</header>
		<aside id="side-menu">
			<ul>
				<li>
					<span>SHOP</span>
					<ul>
						<li><a href="">SUIT</a></li>
						<li><a href="">OUTER</a></li>
						<li><a href="">TOP</a></li>
						<li><a href="">PANTS</a></li>
						<li><a href="">SHOES &amp; BAG</a></li>
						<li><a href="">ACC</a></li>
					</ul>
				</li>
				<li><a href="notice">NOTICE</a></li>
				<li><a href="qna">Q&nbsp;&amp;&nbsp;A</a></li>
				<li><a href="review">REVIEW</a></li>
			</ul>
		</aside>
		<ng-view></ng-view>
	</div>
</body>
</html>