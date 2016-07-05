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

    this.voteRestaurant = function(id, userId, week){

        var data = {'restaurantId':id, 'userId':userId, 'week':week };

        return voteRestaurant(data).then(function(response) {
            return response.data;
        }, function(reason) {
            console.log('Failed voteRestaurant: ' + JSON.stringify(reason));
        });
    }

    function voteRestaurant(data){
        return $http.post("http://localhost:8080/voteRestaurant", data);
    }

    this.getChoosenRestaurant = function(week) {
        var data = {'week':week };
        return getChoosenRestaurant(data).then(function(response) {
            return response.data;
        }, function(reason) {
            console.log('Failed getChoosenRestaurant: ' + JSON.stringify(reason));
        });
    }

    function getChoosenRestaurant(data){
        return $http.post("http://localhost:8080/getChoosenRestaurant", data);
    }


    this.reset = function() {
        return reset().then(function(response) {
            return response.data;
        }, function(reason) {
            console.log('Failed reset: ' + JSON.stringify(reason));
        });
    }

    function reset(){
        return $http.post("http://localhost:8080/reset");
    }

}]