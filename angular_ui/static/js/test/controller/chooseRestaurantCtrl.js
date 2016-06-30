'use strict';

var chai = require('chai')
  , expect = chai.expect;

var TodoServiceModule = require('../../../app/js/service/todos.js');

describe('The TodoService', function() {
  var TodoService;

  beforeEach(function() {
    TodoService = new TodoServiceModule();
  });

  it('should have some todos initially', function() {
    var todos = TodoService.getTodos();
    expect(todos.length).to.equal(4);
    expect(todos[0].title).to.equal('Buy milk');
  });
});