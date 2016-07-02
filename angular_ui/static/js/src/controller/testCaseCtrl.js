'use strict';

module.exports = ['testCaseService',function(testCaseService) {
    this.user = 2;
    this.week = 2;


    this.submit = function (e){
        testCaseService.setUserId(this.user);
        testCaseService.setWeek(this.week);
        console.log('submit test case');
    };
}]