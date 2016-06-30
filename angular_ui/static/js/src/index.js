    'use strict';

var angular = require('angular');
require('angular-animate');
require('angular-aria');
require('angular-material');

var app = angular.module('restaurantApp', [ 'ngMaterial' ]);

app.controller('chooseRestaurantCtrl', require('./controller/chooseRestaurantCtrl'));
app.service('restaurantService', require('./service/restaurantService'))