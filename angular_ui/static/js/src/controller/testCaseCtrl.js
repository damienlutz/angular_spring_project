'use strict';

module.exports = ['testCaseService','navigationService',function(testCaseService, navigationService) {
    this.user = 2;
    this.week = 2;


    this.submit = function (e){
        testCaseService.setUserId(this.user);
        testCaseService.setWeek(this.week);
        console.log('submited the test case');
    };

    this.nextPage = function(){
        return navigationService.getCasePage(this.user);
    }
}]