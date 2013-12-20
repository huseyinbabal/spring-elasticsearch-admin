'use strict';

/**
 * IndicesController
 * @constructor
 */
var IndicesController = function($scope, $http) {
    $scope.getIndiceList = function() {
        $http.get('indices').success(function(carList){
            $scope.indices = indiceList;
        });
    }
}