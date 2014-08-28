'use strict';

angular.module('qameleonApp.services.rest', [])
    .factory('RestServ', ['$resource',
        function($resource) {
            return $resource('http://192.168.1.29:8080/employees/:id', {}, {
                query: {
                    method: 'GET'
                },
                send: {
                    method: 'POST'
                }
            });
        }
    ]);