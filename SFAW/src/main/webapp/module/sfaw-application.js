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

})