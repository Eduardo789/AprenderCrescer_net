myApp.controller('GrupoController', function GrupoController($scope,$http){
  
    $scope.dados = [{"idGrupo": 1,
                    "tipoUsuario": "",
                    "descricaogrupo": "",
                    
    }];
    
    $scope.buscaGrupos = function(){
        GrupoFactory.getGrupos(
                $scope.callbackGrupos);
    }
    
    $scope.callbackGrupos = function(resposta){
        $scope.dados = resposta.data;
    }
})
