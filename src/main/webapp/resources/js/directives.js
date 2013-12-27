/* Directives */

var AppDirectives = angular.module('AppDirectives.directives', []);

AppDirectives.directive('ngJsonCount', function () {
    return {
        restrict: 'E',
        template: "{{count}}",
        scope: {
            jsonObject:'@'
        },
        link: function (scope, elem, attrs) {
            //
            attrs.$observe('jsonObject', function(value){
                if (value.length > 0) {
                    var json = JSON.parse(value);
                    scope.count = (Object.keys(json).length);
                }
            });
        }
    }
});
