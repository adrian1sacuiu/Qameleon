'use strict';

angular.module('qameleonApp.services.project', [])
    .factory('Project', ['$resource',
        function($resource) {
            return $resource('http://localhost:8080/projects/addProject', {}, {
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

    .factory('ProjectId', ['$resource',
        function($resource) {
            return $resource('http://localhost:8080/projects/:id', {}, {
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
