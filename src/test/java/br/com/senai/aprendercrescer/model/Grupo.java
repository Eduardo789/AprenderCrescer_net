/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;


public class Grupo {
    
  int idgrupo ;
  //somente uma letra
  String tipousuario ;
  //descricao do grupo
  String descricaogrupo ;

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getDescricaogrupo() {
        return descricaogrupo;
    }

    public void setDescricaogrupo(String descricaogrupo) {
        this.descricaogrupo = descricaogrupo;
    }

    
    
}
