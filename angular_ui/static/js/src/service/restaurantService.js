'use strict';

module.exports = ['$http', function($http) {

    this.getRestaurants = function() {
            console.log('getRestau');
        return getRestaurants().then(function(response) {
            console.log('getRestau 2');
            return response.data;
        }, function(reason) {
            console.log('Failed getRestaurants: ' + JSON.stringify(reason));
        });
    }

    function getRestaurants(){
        return $http.post("http://localhost:8080/restaurants");
    }

    this.voteRestaurant = function(id, userId, week){

        var data = {'restaurantId':id, 'userId':userId, 'week':week };
        console.log('Data voteRestaurant: ' + JSON.stringify(data));

        return voteRestaurant(data).then(function(response) {
            return response.data;
        }, function(reason) {
            console.log('Failed voteRestaurant: ' + JSON.stringify(reason));
        });
    }

    function voteRestaurant(data){
        return $http.post("http://localhost:8080/voteRestaurant", data);
    }

}]