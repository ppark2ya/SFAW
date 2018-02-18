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
					<c:if test="${not empty sessionScope }">
						<li>
							<form action="user/signout" method="POST">
						    	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
						    	<button id="signout-btn" type="submit">LOGOUT</button>
							</form>
						</li>
					</c:if>
					<c:if test="${empty sessionScope }">
						<li><a href="user/signin">LOGIN</a></li>
					</c:if>
					<li><a href="user/signup">JOIN</a></li>
					<li><a href="user/cart">CART</a></li>
					<li><a href="user/mypage">MY PAGE</a></li>
					<li><a href="search">SEARCH</a></li>
				</ul>
			</div>
		</header>
		<aside id="side-menu">
			<ul>
				<li id="shop">
					<span>SHOP</span>
					<ul id="sub-menu">
						<li><a href="shop/suit">SUIT</a></li>
						<li><a href="shop/outer">OUTER</a></li>
						<li><a href="shop/top">TOP</a></li>
						<li><a href="shop/pants">PANTS</a></li>
						<li><a href="shop/shoesNbag">SHOES &amp; BAG</a></li>
						<li><a href="shop/acc">ACC</a></li>
					</ul>
				</li>
				<li><a href="notice/1">NOTICE</a></li>
				<li><a href="qna">Q &amp; A</a></li>
				<li><a href="review">REVIEW</a></li>
			</ul>
		</aside>
		<ng-view/>
	</div>
</body>
</html>