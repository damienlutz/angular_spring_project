'use strict';

module.exports = ['restaurantService',function(restaurantService) {


    this.submit = function (e){

        restaurantService.reset().then(function(value) {
            console.log('Success: ' + JSON.stringify(value));
        });
        console.log('reset');
    };
}]