'use strict';

angular.module('qameleonApp.controllers.calendar', ['qameleonApp.services.calendar', 'qameleonApp.services.dataservice'])
    .controller('CalendarCtrl', ['$scope', 'Calendar', 'DataService',
        function($scope, Calendar, DataService) {

            $scope.mode = "custom";
            $scope.maxHeight = 0;
            $scope.showWeekends = true;
            $scope.showNonWorkHours = true;

            $scope.data = [];
            var temp = DataService.getProjects();
            $scope.projectData = temp.slice(0);


            $scope.processProjects = function(projectData) {
                for (var i = 0; i < projectData.length; i++) {
                    projectData[i] = {
                        "id": i,
                        "description": projectData[i].name,
                        "order": i,
                        "tasks": [
                            // Dates can be specified as string, timestamp or javascript date object. The data attribute can be used to attach a custom object
                            {
                                "id": projectData[i].idProject,
                                "subject": "Project State: Development",
                                "color": "#93C47D",
                                "from": projectData[i].startDate,
                                "to": projectData[i].endDate,
                                "data": "Project manager: " + projectData[i].projectManager
                            },
                        ],
                        "data": "Can contain any custom data or object"
                    }
                    $scope.data.push(projectData[i]);
                }
                console.log($scope.data);
                return $scope.data;
            }

            $scope.addSamples = function() {
                //$scope.loadData(getSampleData().data1);
                $scope.loadData($scope.processProjects($scope.projectData));
                //console.log($scope.loadData);
            };

            $scope.removeSomeSamples = function() {
                $scope.removeData([{
                        "id": "c65c2672-445d-4297-a7f2-30de241b3145"
                    }, // Remove all Kickoff meetings
                    {
                        "id": "2f85dbeb-0845-404e-934e-218bf39750c0",
                        "tasks": [{
                            "id": "f55549b5-e449-4b0c-9f4b-8b33381f7d76"
                        }, {
                            "id": "5e997eb3-4311-46b1-a1b4-7e8663ea8b0b"
                        }, {
                            "id": "6fdfd775-7b22-42ec-a12c-21a64c9e7a9e"
                        }]
                    }, // Remove some Milestones
                    {
                        "id": "cfb29cd5-1737-4027-9778-bb3058fbed9c",
                        "tasks": [{
                            "id": "57638ba3-dfff-476d-ab9a-30fda1e44b50"
                        }]
                    } // Remove order basket from Sprint 2
                ]);
            };

            $scope.removeSamples = function() {
                $scope.clearData();
            };

            $scope.labelEvent = function(event) {
                // A label has been clicked.
                console.log('Label event (by user: ' + event.userTriggered + '): ' + event.row.description + ' (Custom data: ' + event.row.data + ')');
            };

            $scope.labelHeaderEvent = function(event) {
                // The label header has been clicked.
                console.log('Label header event. Mouse: ' + event.evt.clientX + '/' + event.evt.clientY);
            };

            $scope.rowEvent = function(event) {
                // A row has been added, updated or clicked. Use this event to save back the updated row e.g. after a user re-ordered it.
                console.log('Row event (by user: ' + event.userTriggered + '): ' + event.date + ' ' + event.row.description + ' (Custom data: ' + event.row.data + ')');
            };

            $scope.scrollEvent = function(event) {
                if (angular.equals(event.direction, "left")) {
                    // Raised if the user scrolled to the left side of the Gantt. Use this event to load more data.
                    console.log('Scroll event: Left');
                } else if (angular.equals(event.direction, "right")) {
                    // Raised if the user scrolled to the right side of the Gantt. Use this event to load more data.
                    console.log('Scroll event: Right');
                }
            };

            $scope.taskEvent = function(event) {
                // A task has been updated or clicked.
                console.log('Task event (by user: ' + event.userTriggered + '): ' + event.task.subject + ' (Custom data: ' + event.task.data + ')');
            };
        }
    ]);
