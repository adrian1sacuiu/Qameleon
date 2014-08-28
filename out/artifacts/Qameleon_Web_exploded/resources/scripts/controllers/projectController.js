'use strict';

angular.module('qameleonApp.controllers.project', ['qameleonApp.services.project', 'qameleonApp.services.dataservice'])
    .controller('ProjectCtrl', ['$scope', '$routeParams', '$location', '$timeout', '$compile', 'Project', '$templateCache', '$http', 'DataService',
        function($scope, $routeParams, $location, $timeout, $compile, Project, $templateCache, $http, DataService) {

            //////////////////////////////////
            //        PROJECT HANDLING      //
            //////////////////////////////////

            $scope.projectTags = [];
            
            $scope.isAlert = function() {
                return $scope.alert;
            }
            $scope.alert = false;
            $scope.class = "alert alert-success"; // 'alert-danger'
            $scope.alertTitle = '';
            $scope.alertContent = '';
            

            $scope.firstPage = true;
            $scope.isFirstPage = function(){
                return $scope.firstPage;
            }

            $scope.togglePage = function(){
                $scope.firstPage = !$scope.firstPage;
            }


            $scope.project = {
                name: '',
                type: '',
                startDate: '',
                endDate: '',
                tags: '',
                budgetValue: '',
                budgetType: '',
                description: '',
                //manager: '',
                //phase: ''
            };


            $scope.findAllProjects = function() {
                $scope.projects = Project.query();
                DataService.setProjects($scope.projects);
            }


            $scope.findProject = function(projId) {
                $scope.currentProject = Project.query({
                    id: projId
                });
            }


            $scope.createProject = function() {

                console.log($scope.project);

                var proj = new Project($scope.project);
                proj.$send(function(proj, putResponseHeaders) {
                    $scope.data = proj;
                    console.log($scope.data);

                    $scope.project = {
                        name: '',
                        type: '',
                        startDate: '',
                        endDate: '',
                        tags: '',
                        budgetValue: '',
                        budgetType: '',
                        description: '',
                        //manager: '',
                        //phase: ''
                    };

                    if ($scope.firstPage === false) $scope.togglePage();

                    $scope.class = "alert alert-success";
                    $scope.alertTitle = 'Great';
                    $scope.alertContent = ' Project has been successfully added';
                    $scope.alert = true;
                    console.log($scope.alert);

                    $timeout(function() {
                        $scope.alert = false;
                        console.log($scope.alert);
                    }, 3000);

                }, function(err) {
                    console.log("Error: " + err.status + " " + err.statusText);

                    $scope.project = {
                        name: '',
                        type: '',
                        startDate: '',
                        endDate: '',
                        tags: '',
                        budgetValue: '',
                        budgetType: '',
                        description: '',
                        //manager: '',
                        //phase: ''
                    };

                    if ($scope.firstPage === false) $scope.togglePage();

                    $scope.class = "alert alert-danger";
                    $scope.alertTitle = 'Whoops';
                    $scope.alertContent = ' Can\'t add project due to error: ' + err.status;
                    $scope.alert = true;
                    console.log($scope.alert);

                    $timeout(function() {
                        $scope.alert = false;
                        console.log($scope.alert);
                    }, 3000)
                })
            }


            $scope.removeProject = function(projId) {
                Project.remove({
                    id: projId
                });
            }

            $scope.validProject = function() {
                if ($scope.project.name === '') {
                    $scope.errorname = 'has-error';
                    if ($scope.project.type === '') {
                        $scope.errortype = 'has-error';
                        return false;
                    } else {
                        $scope.errortype = '';
                    }
                    return false;
                } else if ($scope.project.type === '') {
                    $scope.errortype = 'has-error';
                    if ($scope.project.type === '') {
                        $scope.errorname = '';
                    }
                    return false;
                }
                $scope.errorname = '';
                $scope.errortype = '';
                return true;
            }


            //////////////////////////////////
            //        DATE  HANDLING        //
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

            $scope.falseModal = function() {
                $scope.modaldis = "";
            }
        }
    ]);
