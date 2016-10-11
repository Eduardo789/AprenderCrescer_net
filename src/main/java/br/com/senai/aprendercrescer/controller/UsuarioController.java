
package br.com.senai.aprendercrescer.controller;





import br.com.senai.aprendercrescer.dao.UsuarioDao;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Debug.id;



public class UsuarioController {

    UsuarioDao usuarioDao;

    public UsuarioController() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
    }
    
    public boolean insereUsuario(Usuario usuario) {
         usuarioDao.gravar(usuario);
         return true;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarioDao.getAll();
    }
    
    public boolean deleteUsuario(int id){ 
        Usuario us = new Usuario(id);
        usuarioDao.apagar(us);
        return true;
    }

}