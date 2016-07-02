'use strict';

var angular = require('angular');
require('angular-animate');
require('angular-aria');
require('angular-material');
require('angular-route');

var app = angular.module('restaurantApp', [ 'ngMaterial', 'ngRoute']);

app.config(require('./routes'));

app.controller('appCtrl', require('./controller/appCtrl'));
app.controller('chooseRestaurantCtrl', require('./controller/chooseRestaurantCtrl'));
app.controller('testCaseCtrl', require('./controller/testCaseCtrl'));
app.controller('startSessionCtrl', require('./controller/startSessionCtrl'));

app.service('restaurantService', require('./service/restaurantService'))
app.service('testCaseService', require('./service/testCaseService'))
