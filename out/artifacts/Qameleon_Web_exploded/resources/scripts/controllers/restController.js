'use strict';

angular.module('qameleonApp.controllers.rest', ['qameleonApp.services.rest'])
    .controller('RestCtrl', ['$scope', 'RestServ',
        function($scope, RestServ) {

            console.log("RestCtrl working.");


            $scope.sentstatus = '';

            $scope.item = {
                username: "florin",
                firstName: "florin",
                lastName: "florin",
                email: "florin.dobre@qualitance.ro"
            };


            var user = new RestServ($scope.item);
            user.$send(function(user, data) {
                $scope.data = user; //RestServ.query({id: $scope.item.username});
                console.log($scope.data);
            }, function(err) {
                console.log("Error: " + err.status + " " + err.statusText);
            })


        }
    ]);
