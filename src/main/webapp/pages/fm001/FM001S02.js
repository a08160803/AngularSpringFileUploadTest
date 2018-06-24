angular.module('PCMS').controller('FM001S02Controller',
		[ '$scope', '$rootElement', '$http', '$location', function($scope, $rootElement, $http, $location) {
			$scope.textMessage = '';
			
			$scope.init = function() {
				$scope.inputVO = {
						depId : '0901',
						rocDate : '2018-06-24',
						businessId : '003',
						customerName : '',
						customerId : ''
				}
			}
			$scope.init();

			$scope.submit = function() {
				var url = $rootElement.attr('ng-app') + '/FM001S02/incoming' 
				var tita = JSON.stringify($scope.inputVO);
				
				console.log('tita = ', tita);
				
				$http({
					method : 'POST',
					url : url,
					data : tita
				}).then(function successCallback(response) {
					console.table(response.data);
					$scope.textMessage = '開戶審查進件成功';
					$scope.init();
				});
			}
		} ]);