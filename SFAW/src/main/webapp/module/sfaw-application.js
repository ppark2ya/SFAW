/**
 *  AngularJS SFAW application
 */

var SFAW_APP = angular.module("SFAW_APP", ['ngRoute']);

//root directory == webapp
SFAW_APP.config(function($routeProvider, $httpProvider, $locationProvider) {

	$locationProvider.html5Mode(true);

	$routeProvider
//	.when("/", {
//		templateUrl : "/templates/home.html",
//		controller : "home"
//	})
	.when("/user/signin", {
		templateUrl : "/templates/user/signin.html",
		controller : "signinCtrl"
	})
	.when("/user/signup", {
		templateUrl : "/templates/user/signup.html",
		controller : "signupCtrl"
	})
	.when("/user/searchID", {
		templateUrl : "/templates/user/searchID.html",
		controller : "searchIDCtrl"
	})
	.when("/user/forgetPwd", {
		templateUrl : "/templates/user/forgetPwd.html",
		controller : "forgetPwdCtrl"
	})
	.when("/qna", {
		templateUrl : "/templates/board/qna.html",
		controller : "qnaCtrl"
	})
	.when("/notice/:pageNum", {
		templateUrl : "/templates/board/notice.html",
		controller : "noticeCtrl"
	})
	.otherwise({
		redirectTo : "/"
	})

	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

})
.controller("signinCtrl", function(){

})
.controller("signupCtrl", function($scope, $http){

	// 아이디를 사용할 수 있는지 여부를 저장하는 변수
	$scope.canUse = false;
	// 입력되고 있는 id값을 저장하는 객체
	$scope.checkId = {};
	// keyup 이벤트가 발생할 때 실행되는 함수
	$scope.getId = function() {
		// ajax 통신으로 아이디 중복검사
		$http({
			url : "/user/checkId",
			method : "GET",
			params : $scope.checkId
		}).success(function(response) {
			$scope.canUse = response.canUse;
		});
	}
})
.controller("noticeCtrl", function($scope, $http, $routeParams){
	var pageNum = $routeParams.pageNum;
	angular.element(document).ready(function(){
		$http({
			url: "/notice/getNotiList/" + pageNum,
			method: "GET",
			params: {}
		}).success(function(response){

		});
	});

	$scope.prevPage = function(){
		$http({
			url: "/notice/prevPage",
			method: "GET"
		})
	}

	$scope.nextPage = function(){
		$http({
			url: "/notice/nextPage",
			method: "GET"
		})
	}

})