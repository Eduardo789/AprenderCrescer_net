
package br.com.senai.aprendercrescer.controller;




import dao.UsuarioDao;
import java.util.ArrayList;
import model.Usuario;


public class UsuarioController {

    UsuarioDao usuarioDao;

    public UsuarioController() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
    }
    
    public boolean insereUsuario(Usuario usuario) {
        return usuarioDao.insereUsuario(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }
    
    public boolean deleteUsuario(int id){ 
        return usuarioDao.deleteUsuario(id);
    }

}