'use strict';

module.exports = ['restaurantService','testCaseService','$mdToast',
                    function(restaurantService,testCaseService, $mdToast) {
    this.restaurants = [];
    this.restaurant = 1;

    var updateRestaurants = function (scope){
        return function(value) { scope.restaurants = value};
    }(this);

    restaurantService.getRestaurants().then(function(value) {
        updateRestaurants(value);
    });

    this.submit = function (e){
        if (this.form.$invalid) {
            console.log('invalid form');
            return;
        }


        var promise = restaurantService.voteRestaurant(this.restaurant,
                                            testCaseService.getUserId(),
                                            testCaseService.getWeek());
        promise.then(function(greeting) {
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
        }, function(reason) {
            console.log('Failed: ' + reason);
        });
    };
}]