var app = angular.module('app', ['ngRoute']);


app.config(function ($locationProvider, $routeProvider) {

    $routeProvider
            .when("/clientes", {templateUrl: 'view/cliente.html', controller: 'clienteController'})
            .when("/clientes/:clienteId", {templateUrl: 'view/cliente-detalhe.html', controller: 'clienteDetalheController'})
            
            .when("/cidades", {templateUrl: 'view/cidade.html', controller: 'cidadeController'})
            .when("/estados", {templateUrl: 'view/estado.html', controller: 'estadoController'})
            .when("/login", {templateUrl: 'view/login.html', controller: 'loginController'})
            
            
            .otherwise({redirectTo: '/'});

    // configure html5 to get links working on jsfiddle
    $locationProvider.html5Mode(true);

});

