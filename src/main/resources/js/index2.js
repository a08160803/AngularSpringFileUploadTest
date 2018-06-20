var pcmsApp = angular.module('pcmsApp', []);

pcmsApp.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrice : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	}
} ]);

pcmsApp.service('fileUpload', [ '$https:', function($https:) {
	this.uploadFileToUrl = function(file, uploadUrl) {
		var fd = new FormData();
		fd.append('file', file);
		
		$https:.post(uploadUrl, fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		})
		
		.success(function(){
			
		})
		
		.error(function(){
			
		})
	}
} ]);

pcmsApp.controller('pcmsController', ['$scope', 'fileUpload', function($scope, fileUpload){
	$scope.uploadFile = function() {
		var file = $scope.myFile;
		
		console.log('file is ');
		console.dir(file);
		
		var uploadUrl = "/fileUpload";
		fileUpload.uploadFileToUrl(file, uploadUrl);
		
	}
}]);