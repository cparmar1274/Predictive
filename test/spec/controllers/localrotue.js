'use strict';

describe('Controller: LocalrotueCtrl', function () {

  // load the controller's module
  beforeEach(module('predictiveApp'));

  var LocalrotueCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    LocalrotueCtrl = $controller('LocalrotueCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(LocalrotueCtrl.awesomeThings.length).toBe(3);
  });
});
