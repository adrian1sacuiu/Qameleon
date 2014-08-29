'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('qameleonApp', [
    'qameleonApp.controllers.project', 
    'qameleonApp.controllers.employee', 
    'qameleonApp.controllers.header', 
    'qameleonApp.controllers.rest', 
    'qameleonApp.controllers.leave', 
    'qameleonApp.controllers.calendar',
    'qameleonApp.controllers.timeSheet', 
    'ui.bootstrap',
    'ngRoute', 
    'ngResource', 
    'ngTagsInput', 
    'mgcrea.ngStrap', 
    'ngAnimate', 
    'ngSanitize', 
    'mgcrea.ngStrap', 
    'gantt',
	'ngCookies'


])

app.config(
    function($routeProvider, $locationProvider) {


        $routeProvider
            .when('/', {
                templateUrl: '/resources/views/calendar.html'
            })
            .when('/myProfile', {
                templateUrl: '/resources/views/myProfile.html'
            })
            .when('/editTimeSheet', {
                templateUrl: '/resources/views/editTimeSheet.html'
            })
            .when('/projectView', {
                templateUrl: '/resources/views/projectView.html'
            })
            .when('/employeeTable', {
                templateUrl: '/resources/views/employeeTable.html',
                controller: 'EmployeeCtrl'
            })
            .when('/timeSheet', {
                templateUrl: '/resources/views/timeSheet.html'
            })            
            .when('/addproject', {
                templateUrl: '/resources/views/addProject.html',
                controller: 'ProjectCtrl'
            })
            .when('/editEmployee', {
                templateUrl: '/resources/views/editEmployee.html',
                controller: 'EmployeeCtrl'
            })
            .when('/addEmployee', {
                templateUrl: '/resources/views/addEmployee.html',
                controller: 'EmployeeCtrl'
            })
            .when('/leave', {
                templateUrl: '/resources/views/leavePage.html',
                controller: 'LeaveCtrl'
            })
            .when('/calendar', {
                templateUrl: '/resources/views/calendar.html',
                controller: 'CalendarCtrl'
            })
            .when('/rest', {
                templateUrl: '/resources/views/resttest.html'
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }
);

app.config(['$sceDelegateProvider',
    function($sceDelegateProvider) {
        $sceDelegateProvider.resourceUrlWhitelist([
            'self', 'http://192.168.1.29:80/**', 'http://192.168.1.29:8080/**'
        ]);
    }
])

app.config(['$httpProvider',
    function($httpProvider) {

        // delete header from client:
        // http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }
]);

app.config(function($dropdownProvider) {
    angular.extend($dropdownProvider.defaults, {
        html: true
    });
});