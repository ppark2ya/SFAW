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
		controller : "signin"
	})
	.when("/user/signup", {
		templateUrl : "/templates/user/signup.html",
		controller : "signup"
	})
	.when("/user/searchID", {
		templateUrl : "/templates/user/searchID.html",
		controller : "searchID"
	})
	.when("/user/forgetPwd", {
		templateUrl : "/templates/user/forgetPwd.html",
		controller : "forgetPwd"
	})
	.otherwise({
		redirectTo : "/"
	})

	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

})
.controller("signin", function($scope, $http, $location){

})
.controller("signup", function($scope, $http, $location){

	// 아이디를 사용할 수 있는지 여부를 저장하는 변수
	$scope.canUse = false;
	// 입력되고 있는 id값을 저장하는 객체
	$scope.checkId = {};
	// keyup 이벤트가 발생할 때 실행되는 함수
	$scope.getId = function() {
		console.log($scope.checkId);
		// ajax 통신으로 아이디 중복검사
		$http({
			url : "/user/checkId",
			method : "GET",
			params : $scope.checkId
		}).success(function(data) {
			$scope.canUse = data.canUse;
			console.log($scope.canUse);
		})
	}
})