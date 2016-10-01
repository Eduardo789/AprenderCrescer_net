myApp.controller('UsuarioController', function UsuarioController($scope,$http){
    $scope.editando = false;
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
    
    $scope.editarUsuario = function(){
        $scope.editando =! $scope.editando;
    }
    
    $scope.cadastroUsuario = function(usuario){
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario,usuario);
    }
    
    $scope.callbackCadastroUsuario = function(resposta){
        if(resposta.status != 200){
            alert("Deu erro");
        }else{
            alert("Ok");
        }
    }
})
