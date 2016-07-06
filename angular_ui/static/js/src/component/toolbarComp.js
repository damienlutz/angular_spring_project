'use strict';

module.exports = {
   template: "Hello I'm {{$ctrl.myName}}!",
   bindings: { name: '@' },
   controller: function(){
     this.myName = 'Alain';
   }
}