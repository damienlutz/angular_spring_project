'use strict';

module.exports = ['restaurantService','testCaseService','$mdToast',
                    function(restaurantService,testCaseService, $mdToast) {
    this.restaurants = [];
    this.restaurant = 1;

    var updateRestaurants = function (scope){
        return function(value) { scope.restaurants = value};
    }(this);

    restaurantService.getRestaurants().then(function(value) {
        console.log('Success: ' + JSON.stringify(value));
        updateRestaurants(value);
    });

    this.submit = function (e){
        if (this.form.$invalid) {
            console.log('invalid form');
            return;
        }
        console.log('submit');


        restaurantService.voteRestaurant(this.restaurant,
                                            testCaseService.getUserId(),
                                            testCaseService.getWeek()).
            then(function(vote) {
                console.log('Success: ' + JSON.stringify(vote));

                if(vote.valid){
                    $mdToast.show(
                          $mdToast.simple()
                            .textContent('Voto registrado!')
                            .hideDelay(3000)
                        );
                }else{
                    $mdToast.show(
                          $mdToast.simple()
                            .textContent(vote.reason)
                            .hideDelay(3000)
                        );
                }
        });
    };
}]