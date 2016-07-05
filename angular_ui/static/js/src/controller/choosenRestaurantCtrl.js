'use strict';

module.exports = ['restaurantService','testCaseService','$mdToast',
                    function(restaurantService, testCaseService, $mdToast) {

    this.restaurant = {};

    var updateRestaurants = function (scope){
        return function(value) { scope.restaurant = value};
    }(this);

    restaurantService.getChoosenRestaurant(testCaseService.getWeek()).then(function(choosenResponse) {

        if(!choosenResponse.valid){
            $mdToast.show(
                  $mdToast.simple()
                    .textContent(choosenResponse.reason)
                    .hideDelay(3000)
                );
        }
        updateRestaurants(choosenResponse.restaurant);
    });

}]