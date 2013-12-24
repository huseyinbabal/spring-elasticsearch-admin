'use strict';

/**
 * RestController
 * @constructor
 */
var RestController = function($scope, $http) {
    $scope.getRestList = function() {
        $http.get('rest').success(function(restList){
            $scope.rest = restList;
        });
    }
}
