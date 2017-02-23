var App = angular.module('App', [
    'ngRoute', 'ngAnimate', 'userCtrls', 'bookStoreFilters',
    'bookStoreServices', 'bookStoreDirectives'
]);

App.config(function($routeProvider) {
    $routeProvider.when('/register', {
        templateUrl: 'template/register.html',
        controller: 'RegisterCtrl'
    }).when('/listUser', {
        templateUrl: 'template/listUser.html',
        controller: 'UserListCtrl'
    }).otherwise({
        redirectTo: '/listUser'
    })
});
