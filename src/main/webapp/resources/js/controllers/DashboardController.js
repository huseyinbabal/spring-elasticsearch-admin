'use strict';

/**
 * DashboardController
 * @constructor
 */
var DashboardController = function($scope, $http) {
    $scope.getDashBoard = function() {
        $http.get('dashboard').success(function(dashboardList){
            $scope.dashboard = dashboardList;
            console.log(dashboardList);
        });
    }
}