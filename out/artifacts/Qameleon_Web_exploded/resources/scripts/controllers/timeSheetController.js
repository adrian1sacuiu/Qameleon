'use strict';

angular.module('qameleonApp.controllers.timeSheet', [])
    .controller('TimeSheetCtrl', ['$scope', '$location', '$templateCache', '$http', '$alert',
        function($scope, $location, $templateCache, $http, $alert) {

            $scope.switchToEditTimeSheet = function() {
               
                $location.path('/editTimeSheet');
            }

            $scope.switchToTimeSheet = function() {
               
                $location.path('/timeSheet');
            }
        }
    ])
