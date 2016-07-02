'use strict';

module.exports = ['$location',function($location) {

    var urls = {
        chooseRestaurant:'#chooseRestaurant',
        choosenRestaurant:'#choosenRestaurant',
        testCase:'#testCase',
        root:'#/'
    };

    var back = {
        '/chooseRestaurant':urls.testCase,
        '/choosenRestaurant':urls.testCase,
        '/testCase':urls.root
    }
    this.previousPage = function (){
        return back[$location.path()];
    };

    this.getCasePage = function (user){
        if(user == 1){
            return urls.choosenRestaurant;
        }
        return urls.chooseRestaurant;
    };

}]