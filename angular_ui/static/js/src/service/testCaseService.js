'use strict';

module.exports = [function() {
    var userId = -1;
    var week = -1;

    this.getUserId = function (){
        return userId;
    };
    this.setUserId = function (id){
        userId = id;
    };

    this.setWeek = function(value){
        week = value;
    };

    this.getWeek = function(){
        return week;
    };

}]