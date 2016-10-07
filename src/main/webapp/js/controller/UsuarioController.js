myApp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {
    $scope.editando = false;
    $scope.dados = [{"idUsuario": 1, "idGrupo": 1,
            "login": "Eduardo",
            "nome": "Eduardo Tussi",
            "ativo": 'M'
        }];

    $scope.buscaUsuarios = function () {
        UsuarioFactory.getUsuarios(
                $scope.callbackUsuarios);
    }

    $scope.callbackUsuarios = function (resposta) {
        $scope.dados = resposta.data;
    }

    $scope.editarUsuario = function (item) {

        $scope.editando = true;
        $scope.usuario = angular.copy(item);
    }

    if (usuario.idUsuario && usuario.idUsuario != 0) {
        UsuarioFactory.updateUsuario($scope.callbackCadastroUsuario, usuario);
    } else {
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }

    $scope.cadastroUsuario = function (usuario) {
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }

    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            if ($scope.editando == true) {
                swal("Usuario", "Erro ao atualizar o usuario!", "error");
            } else {

                swal("Usuario", "Erro ao cadastrar usuario", "error");
            }

        } else {

            if ($scope.editando == true) {
                swal("Usuario", "Usuario salvo com sucesso!", "success");
            } else {
                swal("Usuario", "Usuario Cadastrado com sucesso!", "success");
            }
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        $scope.usuario.idUsuario = "";
        $scope.usuario.nome = "";
        $scope.usuario.login = "";
        $scope.usuario.flagInativo = "";
        $scope.usuario.idGrupo = "";
        $scope.usuario.senha = "";
        $scope.editando = false;
    }

    $scope.deleteUsuario = function (id) {

        UsuarioFactory.deleteUsuario($scope.callbackDeleteUsuario, id);
    }

    $scope.callbackDeleteUsuario = function (resposta) {
        if (resposta.status != 200) {
            swal("Usuario", "Erro ao deletar usuario", "error");

        } else {
            swal("Usuario", "Usuario deletado com sucesso", "success");
        }
    }

})
