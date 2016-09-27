myApp.controller('UsuarioController', function UsuarioController($scope,$http){
  
    $scope.dados = [{"idUsuario": 1,"idGrupo": 1,
                    "login": "Eduardo",
                    "nome": "Eduardo Tussi",
                    "ativo": 'M'
    }];
    
    $scope.buscaUsuarios = function(){
        UsuarioFactory.getUsuarios(
                $scope.callbackUsuarios);
    }
    
    $scope.callbackUsuarios = function(resposta){
        $scope.dados = resposta.data;
    }
})
