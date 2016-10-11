
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.GrupoDao;
import br.com.senai.aprendercrescer.model.Grupo;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;


public class GrupoController {
    

    GrupoDao grupoDao;

    public GrupoController() {
        if (grupoDao == null) {
            grupoDao = new GrupoDao();
        }
    }
    
    public boolean insereGrupo(Grupo grupo) {
       grupoDao.gravar(grupo);
       return true;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupoDao.getAll();
    }
    
    public boolean deleteGrupo(int id){ 
        Grupo grupo = new Grupo();
        grupo.setIdgrupo(id);
        grupoDao.apagar(grupo);
        return true;
    }

}


