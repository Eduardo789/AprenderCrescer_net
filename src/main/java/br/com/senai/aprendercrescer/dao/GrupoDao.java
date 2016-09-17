
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Grupo;
import br.com.senai.aprendercrescer.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class GrupoDao {
    
    
    
    
    Statement st;
    
    public GrupoDao(){
        try{
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex){
            System.out.println("Erro de conexao"+ ex);
        }
        
    }
    
    public Grupo getGrupoByID(int id){
        ResultSet rs;
        Grupo grupo;
        try{
            rs = st.executeQuery("SELECT  IDGRUPO,TIPOUSUARIO, DESCRICAOGRUPO = " + id);
            while (rs.next()) {
                grupo = new Grupo();
                grupo.setIdgrupo(rs.getInt("IDGRUPO"));
                grupo.setTipousuario(rs.getString("TIPOUSUARIO"));
                grupo.setDescricaogrupo(rs.getString("DESCRICAOGRUPO"));
                return grupo;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereGrupo(Grupo grupo) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDGRUPO)+1, 1) AS IDGRUPO FROM GRUPO ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDGRUPO");
            }
            grupo.setIdgrupo(id);
            sql = "INSERT INTO GRUPO ( IDGRUPO, TIPOUSUARIO, DESCRICAOGRUPO"
                    + "VALUES (" + grupo.getIdgrupo()
                    + ", 0, '" + grupo.getTipousuario()
                    + "' , '" + grupo.getDescricaogrupo()
                    + "' , '" + data.toString()
                    + "', 'F' )";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Grupo> getGrupos() {
        ResultSet rs;
        Grupo grupo;
        ArrayList<Grupo> lista = new ArrayList<Grupo>();
        try {
            rs = st.executeQuery("SELECT  idgrupo, tipousuario, descricaogrupo "
                    + "FROM Grupo");
            while (rs.next()) {
                grupo = new Grupo();
                grupo.setIdgrupo(rs.getInt("IDGRUPO"));
                grupo.setTipousuario(rs.getString("TIPOUSUARIO"));
                grupo.setDescricaogrupo(rs.getString("DESCRICAOGRUPO"));
                
                lista.add(grupo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteGrupo(int id) {
        String sql = "DELETE FROM GRUPO WHERE IDGRUPO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }

}
    
    
    
    
    

