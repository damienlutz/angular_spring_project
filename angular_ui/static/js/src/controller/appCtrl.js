'use strict';

module.exports = ['$location','navigationService',function($location, navigationService) {

    this.goBack = function (){
        return navigationService.previousPage($location.path());
    };
    this.visible = function(){
        return $location.path() != "/";
    }

}]