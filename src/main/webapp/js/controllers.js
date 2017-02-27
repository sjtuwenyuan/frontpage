var userCtrls = angular.module('UserCtrls', []);
userCtrls.controller('UserInfoCtrl', ['$scope', "$http",
    function ($scope, $http) {
        // $scope.ufdrs = {
        //     "subscribeFields": [
        //         1,
        //         3,
        //         2
        //     ],
        //     "columName": {
        //         "1": "name",
        //         "2": "age",
        //         "3": "email"
        //     },
        //     "records": [
        //         {
        //             "1": "huihui",
        //             "2": "25",
        //             "3": "huihui@163.com"
        //         }
        //     ]
        // };
        // $scope.queryInfo = {
        //     "startTime": 123,
        //     "endTime": 456,
        //     "imsi": 789
        // }
        $scope.queryUfdr = function () {
            var startTimes = $scope.queryInfo.startTime.split(" ");
            $scope.queryInfo.startTime = startTimes[0] + '-' + startTimes[1];
            var endTimes = $scope.queryInfo.endTime.split(" ");
            $scope.queryInfo.endTime = endTimes[0] + '-' + endTimes[1];

            var url = 'query/ufdr' + '/starttime/' + $scope.queryInfo.startTime +
                '/endtime/' + $scope.queryInfo.endTime + '/imsi/' + $scope.queryInfo.imsi;
            $http.get(url).success(function (data) {
                $scope.ufdrs = data;
            }).error(function (info, errorcode) {
                alert(errorcode)
                alert(info)
            })
        };
        $scope.resetForm = function () {
            $scope.queryInfo = {
                "startTime": null,
                "endTime": null,
                "imsi": null
            }
        }
    }
]);