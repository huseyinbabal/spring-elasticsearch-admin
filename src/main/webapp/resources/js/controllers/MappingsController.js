'use strict';

/**
 * MappingsController
 * @constructor
 */
var MappingsController = function($scope, $http) {
    $scope.getMappingList = function() {
        $http.get('mappings').success(function(mappingList){
            $scope.mappings = mappingList;
        });
    }
}
