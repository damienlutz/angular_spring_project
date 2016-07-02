'use strict';

module.exports = ['$location',function($location) {

    var back = {
        '/voteRestaurant':'#testCase',
        '/testCase':'#/'
    }
    this.goBack = function (){
        return back[$location.path()];
    };
    this.visible = function(){
        return $location.path() != "/";
    }

}]