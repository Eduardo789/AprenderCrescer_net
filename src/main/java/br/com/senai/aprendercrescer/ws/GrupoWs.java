package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.model.Grupo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/grupo")
public class GrupoWs {

    @GET
    @Path("/getgrupo")
    @Produces("application/json")
    public Response getGrupo() {

        JSONObject retorno = new JSONObject();
        try {
            retorno.put("nome", "Eduardo");
            retorno.put("idade", 20);
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            Logger.getLogger(GrupoWs.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Resposta = "{'nome':'Eduardo'}";

        return Response.status(500).build();
    }

    @GET
    @Path("/getgrupos")
    @Produces("application/json")
    public Response getAllGrupo() {
        try {
            GrupoController grupoControler;
            grupoControler = new GrupoController();
            ArrayList<Grupo> lista
                    = grupoControler.getGrupos();
            JSONObject retorno = new JSONObject();
            JSONObject jGrupo;
            for (Grupo grupo : lista) {
                jGrupo = new JSONObject();
                jGrupo.put("idgrupo", grupo.getIdgrupo());
                jGrupo.put("tipousuario", grupo.getTipousuario());
                jGrupo.put("descricaogrupo", grupo.getDescricaogrupo());
                retorno.put("grupos" + grupo.getIdgrupo(), jGrupo.toString());

            }
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {

            System.out.println("Erro:" + ex);

            return Response.status(200).entity(
                    "{erro:\"" + ex + "\"}").build();
        }
    }
}
