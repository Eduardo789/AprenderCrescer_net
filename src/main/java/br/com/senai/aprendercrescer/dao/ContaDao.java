
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Conta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class ContaDao {
    
    Statement st;
    
    public ContaDao(){
        try{
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex){
            System.out.println("Erro de conexao"+ ex);
        }
        
    }
    
    public Conta getContaByID(int id){
        ResultSet rs;
        Conta conta;
        try{
            rs = st.executeQuery("SELECT idconta, descricao, tipoconta, valor numeric"
                    + " FROM Conta WHERE idconta = " + id);
            while (rs.next()) {
                conta = new Conta();
                conta.setIdconta(rs.getInt("idconta"));
                conta.setDescricao(rs.getString("descricao"));
                conta.setTipoconta(rs.getString("tipoconta"));
                conta.setValor(rs.getDouble("valor"));
                return conta;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereConta(Conta conta) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDUSUARIO)+1, 1) AS IDCONTA FROM CONTA ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDCONTA");
            }
            conta.setIdconta(id);
            sql = "INSERT INTO conta( idconta, descricao, tipoconta, valor )"
                    + "VALUES (" + conta.getIdconta()
                    + ", , '" + conta.getDescricao()
                    + "' , '" + conta.getTipoconta()
                    + "' , '" + conta.getValor();
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Conta> getConta() {
        ResultSet rs;
        Conta conta;
        ArrayList<Conta> lista = new ArrayList<Conta>();
        try {
            rs = st.executeQuery("SELECT  IDUSUARIO, IDGRUPO,LOGIN,"
                    + " SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,"
                    + "FLAGINATIVO FROM USUARIO ");
            while (rs.next()) {
                conta = new Conta();
                conta.setIdusuario(rs.getInt("IDUSUARIO"));
                conta.setLogin(rs.getString("LOGIN"));
                conta.setNome(rs.getString("NOMEUSUARIO"));
                conta.setSenha(rs.getString("SENHAUSUARIO"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteUsuario(int id) {
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }

}    
    
    
    
    
    
}
