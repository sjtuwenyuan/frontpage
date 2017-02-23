var userInfoModule = angular.module('UserInfoModule', []);
userInfoModule.controller('UserInfoCtrl', ['$scope', "$http",
    function ($scope, $http) {
        $scope.autoLogin = true;
        $scope.cates = [
            "用户信息",
            "用户注册"
        ];
        $scope.userInfo = {
            id: 1,
            name: "wenyuan",
            age: 26,
            email: "253445528@qq.com",
            password: "253445528"
        };
        $scope.getFormData = function () {
            console.log($scope.userInfo);
        };
        $scope.setFormData = function () {
            $scope.userInfo = {
                id: 1,
                name: "wenyuan",
                age: 26,
                email: 'damoqiongqiu@126.com',
                password: 'damoqiongqiu'
            }
        };
        $scope.resetForm = function () {
            $scope.userInfo = {
                id: null,
                name: null,
                age: null,
                email: null,
                password: null
            };
        };
        $scope.getAllUser = function () {
            $http.get('list/people').success(function (data) {
                $scope.users = data
            });
        };
        $scope.addUser = function () {
            $http.post('add/people', $scope.userInfo).success(function (data) {
                alert(data)
            });
        };
        $scope.currentId = "用户信息";
        $scope.onClick = function (target) {
            $scope.currentId = target.getAttribute('data');
        }
    }
])
