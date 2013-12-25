/* Directives */

var AppDirectives = angular.module('AppDirectives.directives', []);

AppDirectives.directive('ngJsonCount', function () {
    return {
        restrict: 'E',
        template: '{{count}}',
        scope: {
            jsonObject:'@json'
        },
        link: function (scope, elem, attrs) {
            console.log(attrs);
            //scope.count = Object.keys(attrs.json).length;
        }
    }
});
