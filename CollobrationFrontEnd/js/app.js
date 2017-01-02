//Define an angular module for our app
var sampleApp = angular.module('sampleApp', ['ngRoute']);

//Define Routing for app
//Uri /AddNewOrder -> template add_order.html and Controller AddOrderController
//Uri /ShowOrders -> template show_orders.html and Controller AddOrderController
sampleApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/signup', {
		templateUrl: 'views/userlist.html',
		 controller: 'UserController'
	}).
      when('/login', {
		templateUrl: 'views/login.htm',
		// controller: 'ShowOrdersController'
      }).
      when('/events', {
		templateUrl: 'views/events.html',
		// controller: 'ShowOrdersController'
      }).
      when('/job', {
		templateUrl: 'views/jobs.htm',
		// controller: 'AddOrderController'
      }).
      otherwise({
		redirectTo: '/index.html'
      })
}]);
