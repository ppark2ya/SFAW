/**
 * AngularJs 를 이용한 DynamicBeat 구성하기
 */

var myApp = angular.module("myApp",
		[ "ngRoute", "datatables"]);

var $ = function(selector) {
	return angular.element(document.querySelector(selector));
}
// root directory == webapp
myApp.config(function($routeProvider) {
	$routeProvider.when("/main", {
		templateUrl : "/templates/main.html",
	}).when("/setting", {
		templateUrl : "/templates/setting.html",
		controller : ""
	}).when("/rank", {
		templateUrl : "/templates/rank.html",
		controller : ""
	}).when("/help", {
		templateUrl : "/templates/help.html",
		controller : ""
	}).when("/signup", {
		templateUrl : "/templates/signup.html",
		controller : "signupCtrl"
	}).when("/signin", {
		templateUrl : "/templates/signin.html",
		controller : "signinCtrl"
	}).when("/user", {
		templateUrl : "/templates/user.html",
		controller : ""
	}).when("/music/list", {
		templateUrl : "/templates/music/list.html",
		controller : "listCtrl"
	}).otherwise({
		redirectTo : "/main"
	})
});

myApp.controller("signupCtrl", function($scope, $http) {
	// 아이디를 사용할 수 있는지 여부를 저장하는 변수
	$scope.canUse = false;
	// 입력되고 있는 id값을 저장하는 객체
	$scope.checkId = {};
	// keyup 이벤트가 발생할 때 실행되는 함수
	$scope.getId = function() {
		console.log($scope.checkId);
		// ajax 통신으로 아이디 중복검사
		$http({
			url : "checkId",
			method : "GET",
			params : $scope.checkId
		}).success(function(data) {
			$scope.canUse = data.canUse;
			console.log($scope.canUse);
		})
	}
});

myApp.controller("signinCtrl", function($scope, $http, $location) {
	// id와 password를 담는 객체
	$scope.info = {}
	// submit 이벤트가 발생했을 때 아이디, 패스워드를 검사하여 로그인 처리
	$("#myForm").on("submit", function(e) {
		// 검증을 위해 submit 이벤트를 막아둔다.
		e.preventDefault();
		// ajax 통신을 통해서 아이디, 패스워드를 검증한다.
		$http({
			url : "isValid",
			method : "GET",
			params : $scope.info
		}).success(function(data) {
			// 검증결과 : 회원일 때
			if (data.canLogin) {
				console.log($scope.info);
				// 로그인할 id값을 갖고 있는 form을 submit한다.
				$("#frm").submit();
			} else {
				// 에러메시지를 출력하고 아이디, 패스워드 입력란을 지워준다.
				// angular.element(getRef("#errMsg")).css("display", "block");
				$("#errMsg").css("display", "block");
				$("#id").val("");
				$("#password").val("");
			}
		})
	})
});

myApp.controller("listCtrl", function($scope, $http) {
	// music 테이블의 idx값이 1부터 시작
	$scope.index = 1;
	// music 테이블의 값들을 $scope.musicData에 담는다
	$http({
		url : "getMusic",
		method : "GET",
	}).success(function(data) {
		$scope.musicData = data;
	});

	// 음악 재생을 위한 객체 생성
	// 1개의 audio 객체를 사용해야 음악을 켜고 끌 수 있음
	var audio = $scope.audio = new Audio();
	// 음악 재생 함수 - 음악파일 경로와 음악 onOff 상태값을 매개변수로 받음
	$scope.playSound = function(path, onOff){
		// 음악이 꺼져있을 때
		if(onOff){
			// 음악파일의 크기가 클수록 모바일환경에서 재생 딜레이가 길어짐
			// binary 파일로 변환시켜 파일의 크기를 줄여 딜레이를 최소화시킨다.
			var xhr = new XMLHttpRequest();
			xhr.open("GET", path, true);
			xhr.responseType = "blob";
			// var audio = new Audio();
			xhr.onload = function(){
				audio.src = URL.createObjectURL(xhr.response);
			};
			xhr.send();
			audio.currentTime = 0;
			audio.play();
		}
		// 음악이 재생 중 일때
		else{
			audio.currentTime = 0;
			audio.pause();
			// pause() 된 후에 다시 생성자를 초기화 해줘야 재생이 가능하다.
			audio = new Audio();
		}
	}

	// 음악이 켜져있으면 true, 꺼져있으면 false
	$scope.onOff = false;
	$scope.changeStatus = function(){
		if($scope.onOff)  $scope.onOff = false;
		else  $scope.onOff = true;
	}

	// 음악을 키고 끌 때마다 UI를 바꾸기 위한 함수
	$scope.isOn = function(onOff){
		return onOff ? 'fa-volume-up' : 'fa-volume-off';
	}

	$scope.prev = function(){
		$scope.index--;
		if($scope.index == 0) {$scope.index = 3;}
	}

	$scope.next = function(){
		$scope.index++;
		if($scope.index == 4) {$scope.index = 1;}
	}
	/*
	 * 화면 크기 조절할 때 일어나는 이벤트 resize(function(){})
	angular.element(window).resize(function(){
		$scope.currentWidth = document.body.clientWidth;
		console.log($scope.currentWidth);
	});
	 */

	// 현재 창의 크기
	$scope.currentWidth = document.body.clientWidth;

	// 화면 크기에 따라서 바꿔준다.
	$scope.isMobile = function(width, type){
		if(type === 'btn'){	// 모바일 환경이면 fa-2x
			return (width < 450) ? 'fa-2x' : 'fa-3x';
		}else if(type === 'blank'){	// 모바일 환경이면 col-xs-1 삭제
			return (width < 450) ? false : true;
		}
	};

});
