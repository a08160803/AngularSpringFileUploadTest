angular.module('PCMS')
	.controller('pcmsController', [ '$scope', '$rootElement', '$location', '$http',
		function($scope, $rootElement, $location, $http) {
			
			$scope.toFM001S02 = function () {
		        $location.path('/FM001S02');
		    }
			
			$scope.toFM003 = function () {
				$location.path('/FM003');
			}
			
			$scope.initDB = function(){
				var url = $rootElement.attr('ng-app') + '/initDB';
				
				$http({
					method: 'POST',
					url: url
				}).then(function successCallback(response){
					console.log(response.data.success)
				});
			}
			
		} ]);