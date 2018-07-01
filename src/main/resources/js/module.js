angular.module('PCMS', ['ngRoute'])
	.config([ '$routeProvider', function ($routeProvider) {
            $routeProvider
//            	.when('/FM001S01',{
//            		templateUrl: '/pages/fm001/FM001S01.html',
//            		controller: 'FM001S01Controller'
//            	})
            	.when('/FM001S02',{
            		templateUrl: '/PCMS/pages/fm001/FM001S02.html',
            		controller: 'FM001S02Controller'
            	})
            	.when('/FM003',{
            		templateUrl: '/PCMS/pages/fm003/FM003.html',
            		controller: 'FM003Controller'
            	})
            	.otherwise({
            		redirectTo: '/index.html'
            	})
        }
    ]);