'use strict';

angular.module('qameleonApp.services.employee', [])
    .factory('Employee', ['$resource',
        function($resource) {
            return $resource('http://localhost:8080/employees/addEmployee', {}, {
                query: {
                    method: 'GET',
                    isArray: true
                },
                send: {
                    method: 'POST'
                },
                remove: {
                    method: 'DELETE'
                },
                update: {
                    method: 'PUT'
                }
            });
        }
    ])
    .factory('EmployeeId', ['$resource',
        function($resource) {
            return $resource('http://localhost:8080/employees/:id', {}, {
                query: {
                    method: 'GET',
                    isArray: true
                },                
                remove: {
                    method: 'DELETE'
                },
                update: {
                    method: 'PUT'
                }
            });
        }
    ])
