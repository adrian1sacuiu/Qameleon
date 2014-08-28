'use strict';

angular.module('qameleonApp.controllers.leave', ['qameleonApp.services.leave'])
    .controller('LeaveCtrl', ['$scope', '$routeParams', '$location', '$timeout', '$compile', 'angularFire', 'Leave', '$templateCache', '$http',
        function($scope, $routeParams, $location, $timeout, $compile, angularFire, Leave, $templateCache, $http) {
            
            //////////////////////////////////
            //    DATE & MODAL HANDLING     //
            //////////////////////////////////

            $scope.today = function() {
                $scope.project.startDate = new Date();
                $scope.project.endDate = new Date();
            };
            $scope.today();

            $scope.clear = function() {
                $scope.dt = null;
            };

            $scope.openStart = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.openedStart = true;
                $scope.openedEnd = false;
            };

            $scope.openEnd = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.openedStart = false;
                $scope.openedEnd = true;
            };

            $scope.dateOptions = {
                formatYear: 'yy',
                startingDay: 1
            };

            $scope.initDate = new Date('2016-15-20');
            $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
            $scope.format = $scope.formats[0];

            
        }
    ]);
