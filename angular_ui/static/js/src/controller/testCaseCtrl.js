'use strict';

module.exports = ['testCaseService','navigationService',function(testCaseService, navigationService) {
    this.user = 2;
    this.week = 1;


    this.submit = function (e){
        testCaseService.setUserId(this.user);
        testCaseService.setWeek(this.week);
    };

    this.nextPage = function(){
        return navigationService.getCasePage(this.user);
    }
}]