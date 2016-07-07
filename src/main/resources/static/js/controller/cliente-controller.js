app.controller("clienteController", function ($scope, $http) {

    $scope.cliente = {};
    $scope.clientes = [];

    carregarClientes = function () {

        $http({method: 'GET', url: 'http://localhost:8080/clientes'})
                .then(function (response) {
                    $scope.clientes = response.data;

                }, function (response) {


                });

    };

    $scope.salvarCliente = function () {
        $http({method: 'POST', url: 'http://localhost:8080/clientes', data: $scope.cliente})
                .then(function (response) {

                    carregarClientes();
                    $scope.cliente = {};
                }, function (response) {


                });
    };


    $scope.deleteCliente = function (cliente) {
        $http({method: 'DELETE', url: 'http://localhost:8080/clientes/' + cliente.id})
                .then(function (response) {

                    pos = $scope.clientes.indexOf(cliente);
                    $scope.clientes.splice(pos, 1);

                    $scope.cliente = {};

                }, function (response) {


                });
    };
    
    $scope.updateCliente = function (cli) {
        $scope.cliente = angular.copy(cli);
    };
    
    $scope.cancelCliente = function () {
        $scope.cliente = {};
    };

    carregarClientes();

});