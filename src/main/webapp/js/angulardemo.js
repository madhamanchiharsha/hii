  var app = angular.module("demoApp", []);
    app.controller("demoCtrl", function($scope) {
        $scope.book = "The Alchemist";
        $scope.author = "Paulo Coelho";
    });
    var xhttp= new XMLHttpRequest();
    xhttp.onreadystatechange=function(){
    	if(this.readyState== 4 && this.readyState==200){
    		xhttp.setRequestHeader("Content-Type", "application/json");
    		
    	}
    }