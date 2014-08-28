'use strict';

angular.module('qameleonApp.services.dataservice', [])
    .factory('DataService', [
        function() {
            
            var projects = [{
                idProject: '0',
                name: 'Test',
                projectManager: 'Gigi',
                startDate: 'Tue Aug 26 2014 16:06:13 GMT+0300 (GTB Daylight Time)',
                endDate: 'Tue Nov 3 2014 16:06:13 GMT+0300 (GTB Daylight Time)',
                type: 'ceva',
                description: 'blabla'
            },
            {
                idProject: '1',
                name: 'Test2',
                projectManager: 'Ion',
                startDate: 'Tue Aug 26 2014 16:06:13 GMT+0300 (GTB Daylight Time)',
                endDate: 'Tue Aug 29 2014 16:06:13 GMT+0300 (GTB Daylight Time)',
                type: 'ceva2',
                description: 'blabla2'
            }];
            
            var employees = [{
                firstName: 'Ion',
                lastName: 'Testeru',
                tags: [{"text":"testing"},{"text":"selenium"},{"text":"ibm ceva"}]
            },
            {
                firstName: 'Gigi',
                lastName: 'Programatoru',
                tags: [{"text":"php"},{"text":"java"},{"text":"angular"}]
            }];

            return {
                setProjects: function(proj){
                    projects = proj;
                },
                getProjects: function(){
                    return projects;
                },
                setEmployees: function(u){
                    employees = u;
                },
                getEmployees: function(){
                    return employees;
                }
            }
        }
    ])