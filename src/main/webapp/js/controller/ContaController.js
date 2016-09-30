myApp.controller('ContaController', function ContaController($scope,$http){
  
    $scope.dados = [{" idconta": 1,
                    "descricao": "",
                    "tipoconta": "",
                    "valor": ""
    }];
    
    $scope.buscaContas = function(){
        ContaFactory.getContas(
                $scope.callbackContas);
    }
    
    $scope.callbackContas = function(resposta){
        $scope.dados = resposta.data;
    }
})



