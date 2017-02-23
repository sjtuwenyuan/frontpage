var userCtrls = angular.module('UserCtrls', []);
userCtrls.controller('UserInfoCtrl', ['$scope', "$http",
    function ($scope, $http) {
        $scope.autoLogin = true;
        $scope.choices = [{
            url: "#/listUser",
            page: "用户信息"
        }, {
            url: "#/register",
            page: "用户注册"
        }
        ];
        $scope.currentUrl = "#/listUser";
        $scope.isListUser = true;
        $scope.isRegister = false;
        $scope.onClick = function (target) {
            $scope.currentUrl = target.getAttribute('href');
            var curl = $scope.currentUrl;
            $scope.resetNgShow();
            if (curl == "#/listUser") {
                $scope.isListUser = true;
            } else if (curl == "#/register") {
                $scope.isRegister = true;
            }
        };
        $scope.getAllUser = function () {
            $http.get('list/people').success(function (data) {
                $scope.users = data;
            });
        };
        $scope.resetNgShow = function () {
            $scope.isListUser = false;
            $scope.isRegister = false;
        }

    }
])
userCtrls.controller('RegisterCtrl', ['$scope', "$http",
    function ($scope,$http) {
        $scope.addUser = function () {
            $http.post('add/people', $scope.userInfo).success(function (data) {
                alert(data)
            });
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
        $scope.pageClass = "register";
    }
]);

userCtrls.controller('UserListCtrl', ['$scope', "$http",
    function ($scope, $http) {
        $scope.getAllUser = function () {
            $http.get('list/people').success(function (data) {
                $scope.users = data;
            });
        };
    }
]);

/**
 * 这里接着往下写，如果控制器的数量非常多，需要分给多个开发者，可以借助于grunt来合并代码
 */
