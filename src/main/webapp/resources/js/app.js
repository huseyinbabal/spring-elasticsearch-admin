var SpringElasticsearchAdmin = angular.module('SpringElasticsearchAdmin', [
    'ngRoute',
    'AppDirectives.directives'
]);

SpringElasticsearchAdmin.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/dashboard', {
        templateUrl: 'dashboard/layout',
        controller: DashboardController
    });

    $routeProvider.when('/indices', {
        templateUrl: 'indices/layout',
        controller: IndicesController
    });

    $routeProvider.when('/query', {
        templateUrl: 'query/layout',
        controller: QueryController
    });

    $routeProvider.when('/mappings', {
        templateUrl: 'mappings/layout',
        controller: MappingsController
    });

    $routeProvider.when('/rest', {
        templateUrl: 'rest/layout',
        controller: RestController
    });

    $routeProvider.otherwise({redirectTo: '/dashboard'});
}]);
