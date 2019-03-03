'use strict'

var demoApp = angular.module('demo', ['ui.bootstrap', 'angspr.controllers',
    'angspr.services'
]);

demoApp.constant("CONSTANTS", {
    ping: "/angspr/ping/"
    //getUserByIdUrl: "/user/getUser/",
    //getAllUsers: "/user/getAllUsers",
    //saveUser: "/user/saveUser"
});