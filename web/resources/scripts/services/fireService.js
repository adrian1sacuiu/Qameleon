'use strict';

angular.module('qameleonApp.services.firebaseRefs', [])
    .factory('FireRef', ['FBURL', 'Firebase',
        function(FBURL, Firebase) {
            return {
                projects: function() {
                    return new Firebase(FBURL + '/projects');
                },
                employees: function() {
                    return new Firebase(FBURL + '/employees');
                }
            }
        }
    ])
