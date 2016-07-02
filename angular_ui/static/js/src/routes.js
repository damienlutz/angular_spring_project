'use strict';

module.exports = function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : 'pages/startSession.html',
            controller  : 'startSessionCtrl as startSession'
        })

        // route for the about page
        .when('/testCase', {
            templateUrl : 'pages/testCase.html',
            controller  : 'testCaseCtrl as testCase'
        })

        // route for the contact page
        .when('/voteRestaurant', {
            templateUrl : 'pages/chooseRestaurant.html',
            controller  : 'chooseRestaurantCtrl as chooseRestaurant'
        });
};
