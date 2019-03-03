'use strict'

var module = angular.module('angspr.controllers', []);
module.controllers("UserController", ["$scope",
   function($scope) {
        $scope.ping = function() {
            return UserController.ping();
        };
   }
]);