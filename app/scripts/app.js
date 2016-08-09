'use strict';

/**
 * @ngdoc overview
 * @name predictiveApp
 * @description
 * # predictiveApp
 *
 * Main module of the application.
 */
angular
  .module('predictiveApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
