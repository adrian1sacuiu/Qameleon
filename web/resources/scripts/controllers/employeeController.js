'use strict';

angular.module('qameleonApp.controllers.employee', ['qameleonApp.services.employee'])
    .controller('EmployeeCtrl', ['$scope', '$routeParams', '$location', 'Employee', 'EmployeeId',
        function($scope, $routeParams, $location, Employee, EmployeeId) {

            $scope.employee = {
                firstName: '',
                lastName: '',
                email: '',
                username: ''

            };

            $scope.editedEmployee = {                
                employeeType: '',                
                level: '',
                compentences: '',
                competenceLevel: '',
                tags: '',
                startDate: '',
                contractType: ''
            };


            $scope.employeeList = [];

            var e = Employee.query(function(empl, getResponseHeaders) {
                console.log(empl);
                return empl;
            });

            $scope.employeeList = e;


            $scope.switchToEditEmployee = function() {
                $location.path('/editEmployee');
            }

            $scope.findAllEmployees = function() {
                $scope.employees = Employee.query();
                console.log($scope.employees);
            }

            $scope.findEmployee = function(uname) {
                $scope.currentEmployee = EmployeeId.query({
                    id: uname
                });
                console.log($scope.currentEmployee);
            }

            $scope.createEmployee = function() {
                $scope.employee.username = $scope.employee.firstName + "_" + $scope.employee.lastName;
                $scope.employee.email = $scope.employee.firstName + "." + $scope.employee.lastName + "@qualitance.ro";
                var empl = new Employee($scope.employee);
                empl.$send(function(empl, putResponseHeaders) {
                    $scope.data = empl;
                    console.log($scope.data);

                    $scope.employee = {
                        firstName: '',
                        lastName: '',
                        email: '',
                        username: '',

                    };


                }, function(err) {
                    console.log("Error: " + err.status + " " + err.statusText);
                })
            }

            $scope.initCurrentEmployee = function(username){
                $scope.currentEmployee = EmployeeId.query({
                    id: username                    
                });
                console.log($scope.currentEmployee);
            }

            $scope.editEmployee = function() {
                console.log($scope.currentEmployee);
                var updt = new EmployeeId($scope.currentEmployee[0]);
                updt.$update(function(updt, putResponseHeaders) {
                    $scope.data = updt;
                    console.log($scope.data);  

                }, function(err) {
                    console.log("Error: " + err.status + " " + err.statusText);
                })
            }

            $scope.removeEmployee = function(uname) {
                EmployeeId.remove({
                    id: uname
                });
            }


            $scope.openStart = function($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.openedStart = true;
            };

        }
    ]);
