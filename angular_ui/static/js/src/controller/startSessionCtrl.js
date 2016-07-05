'use strict';

module.exports = ['restaurantService',function(restaurantService) {


    this.submit = function (e){
        console.log("alo");
        restaurantService.reset();
    };
}]