'use strict';

module.exports = ['$http', function($http) {

    this.getRestaurants = function() {
        return getRestaurants().then(function(response) {
            return response.data;
        }, function(reason) {
            console.log('Failed getRestaurants: ' + JSON.stringify(reason));
        });
    }

    function getRestaurants(){
        return $http.post("http://localhost:8080/restaurants");
    }

    this.voteRestaurant = function(id){
        return voteRestaurant(id).then(function(response) {
            return response.data;
        }, function(reason) {
            console.log('Failed voteRestaurant: ' + JSON.stringify(reason));
        });
    }

    function voteRestaurant(id){
        var data = {restaurantId:id, userId:1 };
        return $http.post("http://localhost:8080/voteRestaurant", data);
    }
}]