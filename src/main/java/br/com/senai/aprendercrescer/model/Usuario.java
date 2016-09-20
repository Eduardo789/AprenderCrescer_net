
package br.com.senai.aprendercrescer.model;

import java.util.Date;


public class Usuario {
    
    private int idgrupo;
    private String login;
    private String senha;
    private String nome;
    private char flagInativo;
    private Date dtAlteracao;
    private int idUsuario;

    public int getIdusuario() {
        return idUsuario;
    }

    public void setIdusuario(int idusuario) {
        this.idUsuario = idusuario;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getFlagInativo() {
        return flagInativo;
    }

    public void setFlagInativo(char flagInativo) {
        this.flagInativo = flagInativo;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    
    
        
}
