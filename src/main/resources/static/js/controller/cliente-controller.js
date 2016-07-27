app.controller("clienteController", function ($scope, $http) {

    $scope.cliente = {};
    $scope.clientes = [];

    carregarClientes = function () {

        $http({method: 'GET', url: '/admin/clientes'})
                .then(function (response) {
                    $scope.clientes = response.data;

                }, function (response) {


                });

    };

    $scope.salvarCliente = function () {
        
        if ($scope.frmCliente.$valid) {
            
                $http({method: 'POST', url: '/admin/clientes', data: $scope.cliente})
                    .then(function (response) {

                        carregarClientes();
                        $scope.cliente = {};
                        
                        $scope.frmCliente.$setPristine(true);
                        
                    }, function (response) {


                    });
                
        } else {
            window.alert("Dados inválidos !");
        }
    };


    $scope.deleteCliente = function (cliente) {
        $http({method: 'DELETE', url: '/admin/clientes/' + cliente.id})
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