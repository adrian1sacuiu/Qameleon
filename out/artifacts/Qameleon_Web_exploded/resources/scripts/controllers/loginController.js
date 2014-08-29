'use strict';

angular.module('qameleonApp.controllers.login', [])
    .controller('LoginCtrl', ['$scope', '$location', '$rootScope', '$cookieStore',
        function($scope, $location, $rootScope, $cookieStore) {
            $scope.$on('$locationChangeStart', function(event) {
                console.log('Login check working');

                var favoriteCookie = $cookieStore.get('JSESSIONID');

                if (favoriteCookie === undefined){
                	//$location.path('/login');
                    $window.location.href = 'http://localhost:8080/login';
                	console.log("Not logged in");
                }
            });
        }
    ])
