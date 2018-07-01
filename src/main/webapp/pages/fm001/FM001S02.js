angular.module('PCMS').controller('FM001S02Controller',
		[ '$scope', '$rootElement', '$http', '$location', function($scope, $rootElement, $http, $location) {
			$scope.textMessage = '';
			
			$scope.init = function() {
				$scope.inputVO = {
						depId : '0901',
						rocDate : '2018-06-30',
						businessId : '003',
						customerName : '',
						customerId : '',
						flowMainSeq: 0,
						flowBranchSeq: 0,
						tradeId: ''
				}
				$scope.imgsrc = '';
			}
			$scope.init();

			$scope.submit = function(event) {
				// ==================== 純測試檔案上傳 ====================
//				var url = $rootElement.attr('ng-app') + '/FileUpload';
//				
//				var tita = JSON.stringify($scope.inputVO);
//				$http({
//					method: 'POST',
//					url: url,
//					headers: {
//		                'Content-Type': undefined
//		            },
//					data: {
//						file: $scope.file
//					},
//					transformRequest: function (data, headersGetter) {
//		                var formData = new FormData();
//		                angular.forEach(data, function (value, key) {
//		                    formData.append(key, value);
//		                });
//
//		                var headers = headersGetter();
//		                delete headers['Content-Type'];
//
//		                return formData;
//		            }
//				}).then(function successCallBack(response){
//					
//				});
				
				// ==================== 進件 =======================
				var url = $rootElement.attr('ng-app') + '/FM001S02/incoming'
				
				var tita = JSON.stringify($scope.inputVO);
				console.log('tita = ', $scope.inputVO);
				
				$http({
					method: 'POST',
					url: url,
					headers: {
		                'Content-Type': undefined
		            },
		            data: {
		            	formData: tita,
						file: $scope.file
					},
					transformRequest: function (data, headersGetter) {
		                var formData = new FormData();
		                angular.forEach(data, function (value, key) {
		                    formData.append(key, value);
		                });

		                var headers = headersGetter();
		                delete headers['Content-Type'];

		                return formData;
		            }
				}).then(function successCallback(response) {
					console.table(response);
					$scope.textMessage = '開戶審查進件成功';
					$scope.init();
					
					var tota = response.data;
					$scope.inputVO.flowMainSeq = tota.flowMainSeq; 
					$scope.inputVO.flowBranchSeq = tota.flowBranchSeq;
					$scope.inputVO.businessId = tota.businessId;
					$scope.inputVO.tradeId = tota.tradeId;
				});
			}
			
			$scope.fileDownload = function() {
				var url = $rootElement.attr('ng-app') + '/FileDownload?flowMainSeq=' + $scope.inputVO.flowMainSeq;
				
				var myParams = {
						"filename": $scope.inputVO.flowMainSeq
				};
				
				$http({
					method: 'GET',
					url: url
				}).then(function successCallback(data, status, headers, config){
//					$scope.imgsrc = response.data;
//					$scope.image= response.data;
//					console.log('response.data >>>>> ', response.data);
//					console.log('image', $scope.image);
					var blob = new Blob( [data] , { type: "application/octet-stream"} );
					var objectUrl = URL.createObjectURL( blob );
					var downloadLink = angular.element('<a></a>');
	                downloadLink.attr('href', URL.createObjectURL(blob));
	                downloadLink.attr('target','_self');
	                downloadLink.attr('download', myParams['filename'] ); /*檔名*/
	                downloadLink[0].click(); /*點一下<a>*/
					
//					var content = response.data;
//					var blob = new Blob([ content ], { type : 'application/octet-stream' });
//					$scope.url = (window.URL || window.webkitURL).createObjectURL( blob );
				});
				

			}
		} ]);