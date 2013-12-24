'use strict';

/**
 * QueryController
 * @constructor
 */
var QueryController = function($scope, $http) {
    $scope.getQueryList = function() {
        $http.get('query').success(function(queryList){
            $scope.query = queryList;
        });
    }
}