'use strict';

angular.module('qameleonApp.controllers.header', ['qameleonApp.services.dataservice'])
    .controller('HeaderController', ['$scope', '$location', '$templateCache', '$http', '$alert', 'DataService',
        function($scope, $location, $templateCache, $http, $alert, DataService) {

            $scope.ssProject = 'active';
            $scope.ssEmployee = '';
            var firstLoadProj = DataService.getProjects();
            var firstLoadEmpl = DataService.getEmployees();


            $scope.switchToE = function() {
                $scope.ssProject = '';
                $scope.ssEmployee = 'active';
                $location.path('/calendar');
            }

            $scope.switchToP = function() {
                $scope.ssProject = 'active';
                $scope.ssEmployee = '';
                $location.path('/calendar');
            }


            $scope.logout = function() {
                loginService.logout('/signin');
            };

            $scope.$alert = function(title) {
                $alert({
                    title: title,
                    content: 'Logging you out now.',
                    duration: 2,
                    placement: 'top',
                    type: 'info',
                    keyboard: true,
                    show: true
                });
            };

            $scope.selectedSearchFor = '';
            $scope.searchFor = [{
                value: 'employee',
                label: '<i class="fa fa-heart"></i> Employee'
            }, {
                value: 'project',
                label: '<i class="fa fa-globe"></i> Project'
            }, {
                value: 'tags',
                label: '<i class="fa fa-gear"></i> Tags'
            }];

            $scope.selectedFoundItem = '';
            $scope.itemsBucket = [];

            $scope.adminOptions = [{
                "text": "Add Project",
                "href": "#addproject"
            }, {
                "text": "Add Employee",
                "href": "#addEmployee"
            }];

            $scope.myUser = [{
                "text": "Logout",
                "click": "$alert('Goodbye!')"
            }, {
                "text": "Report a Bug",
                "href": "#"
            }];


            $scope.$watch('selectedSearchFor',
                function(newValue, oldValue) {
                    $scope.prepareSearchBox(newValue.value);
                }
            );

            console.log(firstLoadProj[0].name);

            $scope.searchIt = function(){
                if ($scope.selectedSearchFor.value === "project"){
                    for (var i = 0; i < firstLoadProj.length; i++){
                        if ($scope.selectedFoundItem === firstLoadProj[i].name){
                            console.log("pass");
                        }
                    }
                }
                if ($scope.selectedSearchFor.value === "employee"){

                }
                if ($scope.selectedSearchFor.value === "tags"){
                    
                }
            }


            $scope.prepareSearchBox = function(item) {
                if (item === 'project') {
                    var t = DataService.getProjects();
                    var temp = t.slice(0);

                    for (var i = 0; i < temp.length; i++) {
                        temp[i] = temp[i].name;
                    }
                    $scope.itemsBucket = temp;
                }else if (item === 'employee') {
                    var t = DataService.getEmployees();
                    var temp = t.slice(0);

                    for (var i = 0; i < temp.length; i++) {
                        temp[i] = temp[i].firstName + " " + temp[i].lastName;
                    }
                    $scope.itemsBucket = temp;
                }else if (item === 'tags') {
                    var t = DataService.getEmployees();
                    var temp = t.slice(0);

                    for (var i = 0; i < temp.length; i++) {

                        var tagtemp = [];

                        for (var j = 0; j < temp[i].tags.length; j++) {
                            tagtemp.push(temp[i].tags[j].text);
                        }
                        temp[i] = temp[i].firstName + " " + temp[i].lastName + " [" + tagtemp + "]";
                    }
                    $scope.itemsBucket = temp;
                }
            };

        }
    ])
