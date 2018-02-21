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

	// 페이징 요청
	$http({
		url: "/notice/getNotiList/" + $routeParams.pageNum,
		method: "GET",
	}).success(function(response){
		// 게시판 글 목록 리스트
		$scope.notiList = response.notiList;

		// 페이징 처리 정보 pageInfo
		var info = response.pageInfo;
		$scope.pageNumArray = [];

		for(var i = info.firstPage; i <= info.lastPage; i++){
			var obj = {
				pageNum : i,
				url : "/notice/" + i
			};
			$scope.pageNumArray.push(obj);
		}

		// 이전 페이지가 없을 때 화살표 삭제
		if(info.prevPage === 0){
			$scope.canPrev = false;
		}else{
			$scope.canPrev = true;
			$scope.prevPage = info.prevPage;
			var prev = document.querySelector("#page-display a:first-child");
			prev.setAttribute("href", "/notice/" + info.prevPage);
		}
		// 다음 페이지가 없을 때 화살표 삭제
		if(info.nextPage === 0){
			$scope.canNext = false;
		}else{
			$scope.canNext = true;
			$scope.nextPage = info.nextPage;
			var next = document.querySelector("#page-display a:last-child")
			next.setAttribute("href", "/notice/" + info.nextPage);
		}

		// 현재 페이지 active 표시
		$scope.activeNum = $routeParams.pageNum;
	});
})