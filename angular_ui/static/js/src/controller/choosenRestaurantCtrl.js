'use strict';

module.exports = ['restaurantService','testCaseService',
                    function(restaurantService, testCaseService) {

    this.restaurant = {};

    var updateRestaurants = function (scope){
        return function(value) { scope.restaurant = value};
    }(this);

    restaurantService.getChoosenRestaurant(testCaseService.getWeek()).then(function(value) {
        console.log('Success: ' + JSON.stringify(value));
        updateRestaurants(value);
    });

}]