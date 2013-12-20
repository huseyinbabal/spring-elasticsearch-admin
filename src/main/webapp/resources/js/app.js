'use strict';

var SpringElasticsearchMontior = {};

var App = angular.module('SpringElasticsearchMontior', []);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'main/layout',
        controller: CarController
    });

    $routeProvider.when('/indices', {
        templateUrl: 'indices/layout',
        controller: CarController
    });

    $routeProvider.when('/query', {
        templateUrl: 'query/layout',
        controller: TrainController
    });

    $routeProvider.when('/mappings', {
        templateUrl: 'mappings/layout',
        controller: RailwayStationController
    });

    $routeProvider.when('/rest', {
        templateUrl: 'rest/layout',
        controller: RailwayStationController
    });

    $routeProvider.otherwise({redirectTo: '/'});
}]);
