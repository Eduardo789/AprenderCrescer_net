package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.ContaDao;
import br.com.senai.aprendercrescer.model.Conta;
import java.util.ArrayList;

public class ContaController {

    ContaDao contaDao;

    public ContaController() {
        if (contaDao == null) {
            contaDao = new ContaDao();
        }
    }

    public boolean insereConta(Conta conta) {
        contaDao.gravar(conta);
        return true;
    }

    public ArrayList<Conta> getConta() {
        return contaDao.getAll();
    }

    public boolean deleteConta(int id) {
        Conta conta = new Conta(id);
        ContaDao.apagar(conta);
        return true;
    }

}


