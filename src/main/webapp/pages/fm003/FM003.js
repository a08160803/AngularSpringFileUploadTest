angular.module('PCMS').controller('FM003Controller',
		[ '$scope', '$rootElement', '$http', '$location', function($scope, $rootElement, $http, $location) {
			$scope.textMessage = '';
			
			$scope.includeUrl = $rootElement.attr('ng-app') + '/pages/common/COMMON_SELF_BUILD.html';
			
			$scope.init = function() {
				$scope.inputVO = {
//						depId : '0901',
//						rocDate : '2018-06-24',
//						businessId : '003',
//						customerName : '',
//						customerId : ''
				}
				
				var url = $rootElement.attr('ng-app') + '/FM003/inquire'
				$http({
					method: 'GET',
					url: url
				}).then(function successCallback(response) {
					console.log('response >>>>> ', response);
				});
				
			}
			$scope.init();
			
			$scope.toUrl = "../pages/common/COMMON_SELF_BUILD.html";
		} ]);