/**
 *  AngularJS SFAW application
 */

var SFAW_APP = angular.module("SFAW_APP", ['ngRoute']);


//root directory == webapp
SFAW_APP.config(function($routeProvider, $httpProvider) {

	$routeProvider.when("/", {
		templateUrl : "/templates/home.html",
		controller : "home"
	})
	.when("/user/signin", {
		templateUrl : "/templates/signin.html",
		controller : "signin"
	})
	.when("/user/signup", {
		templateUrl : "/templates/signup.html",
		controller : ""
	})
	.otherwise({
		redirectTo : "/"
	})

	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

})
.controller("signin", function($scope, $http, $location){

});