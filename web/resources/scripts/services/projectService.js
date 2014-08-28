'use strict';

angular.module('qameleonApp.services.project', [])
    .factory('Project', ['$resource',
        function($resource) {
            return $resource('http://192.168.1.29:8080/projects/addProject/:id', {}, {
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
