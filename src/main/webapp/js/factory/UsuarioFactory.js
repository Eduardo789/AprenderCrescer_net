'use strict'

myApp.factory('UsuarioFactory', ['$http', function ($http) {
        return{
            getUsuarios: function (callback) {
                $http({"method": "GET",
                    "url": "/AprenderCrescer/rest/usuario/getusuarios"})
                        .then(function (resposta) {
                            callback(resposta);
                        });
            },
            setUsuario: function (callback, usuario) {
                $http({"method": "POST",
                    "url": "/AprenderCrescer/rest/usuario/setusuario",
                    "headers": {"Content-Type": "application/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
            updateUsuario: function (callback, usuario) {
                $http({"method": "POST",
                    "url": "/AprenderCrescer/rest/usuario/updateusuario",
                    "headers": {"Content-Type": "application/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
            deleteUsuarios: function (callback, id) {
                $http({"method": "GET",
                    "url": "/AprenderCrescer/rest/usuario/deleteusuario/" + id})
                        .then(function (resposta) {
                            callback(resposta);
                        });
            },
        };
    }]);
