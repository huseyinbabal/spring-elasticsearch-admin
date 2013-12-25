'use strict';

/**
 * DashboardController
 * @constructor
 */

var DashboardController = function($scope, $http) {

    $scope.getDashBoardHealth = function() {
        $http.get('dashboard/health').success(function(health){
            $scope.health = health;
        });
    }

    $scope.getDashBoardState = function() {
        $http.get('dashboard/state').success(function(state){
            $scope.state = state;
        });
    }

    $scope.getDashBoardHealth();
    $scope.getDashBoardState();
}