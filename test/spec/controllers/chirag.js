'use strict';

describe('Controller: ChiragCtrl', function () {

  // load the controller's module
  beforeEach(module('predictiveApp'));

  var ChiragCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ChiragCtrl = $controller('ChiragCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ChiragCtrl.awesomeThings.length).toBe(3);
  });
});
