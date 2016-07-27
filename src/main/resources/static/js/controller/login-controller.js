app.controller("loginController", function ($scope, $http) {

    $scope.user = {};
    
    $scope.token = "";

    $scope.autentication = function () {

        $http.post("/autenticar", $scope.user).then(
                
                function (response) {

                    console.log("Sucesso" + response);
                    
                    $scope.token = response.data.token;

                }, function (response) {

                    console.log("Falha" + response);
        });

    }

});


