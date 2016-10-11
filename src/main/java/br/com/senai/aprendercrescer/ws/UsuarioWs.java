package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/usuario")
public class UsuarioWs {

    @GET
    @Path("/getusuario")
    @Produces("application/json")
    public Response getUsuario() {

        JSONObject retorno = new JSONObject();
        try {
            retorno.put("nome", "Eduardo");
            retorno.put("idade", 26);
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Resposta = "{'nome':'Eduardo'}";

        return Response.status(500).build();
    }

    @GET
    @Path("/getusuarios")
    @Produces("application/json")
    public Response getAllUsuarios() {
        // ArrayList<JSONObject> listaJson = new ArrayList<JSONObject>();

        try {
            UsuarioController ususarioControler;
            ususarioControler = new UsuarioController();
            ArrayList<Usuario> lista = ususarioControler.getUsuarios();

            JSONObject jUsuario;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Usuario usuario : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jUsuario = new JSONObject();
                jUsuario.put("idUsuario", usuario.getIdusuario());
                jUsuario.put("idGrupo", usuario.getIdgrupo());
                jUsuario.put("login", usuario.getLogin());
                jUsuario.put("senha", usuario.getSenha());
                jUsuario.put("nome", usuario.getNome());
                jUsuario.put("flagInativo", usuario.getFlagInativo() + "");
                retorno.append(jUsuario.toString());
                controle = true;
            }

            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
            return Response.status(200).entity(
                    "{erro : \"" + ex + "\"}").build();

        }
    }

    @POST
    @Path("/setusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setUsuario(InputStream dadosServ) {

        StringBuilder requisicaoFinal = new StringBuilder();

        try {
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(dadosServ));

            String requisicao = "";
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);

            }
            System.out.println(requisicaoFinal.toString());

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            Usuario usuario = new Usuario();
            usuario.setLogin(resposta.getString("login"));
            usuario.setNome(resposta.getString("nome"));
            usuario.setSenha(resposta.getInt("senha") + "");
            usuario.setIdgrupo(resposta.getInt("idGrupo"));
            usuario.setFlagInativo(resposta.getString("flagInativo"));
            usuario.setDtalteracao(new Date());

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\"" + ":\"Cadastrado\"}").build();
            } else {
                return Response.status(501).entity("{\"result\" : \"Erro no Cadastro\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

    }

    @POST
    @Path("/updateusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUsuario(InputStream dadosServ) {

        StringBuilder requisicaoFinal = new StringBuilder();

        try {
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(dadosServ));

            String requisicao = "";
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);

            }
            System.out.println(requisicaoFinal.toString());

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            Usuario usuario = new Usuario();
            usuario.setIdusuario(resposta.getInt("idusuario"));

            usuario.setLogin(resposta.getString("login"));
            usuario.setNome(resposta.getString("nome"));
            usuario.setSenha(resposta.getInt("senha") + "");
            usuario.setIdgrupo(resposta.getInt("idGrupo"));
            usuario.setFlagInativo(resposta.getString("flaginativo"));
            usuario.setDtalteracao(new Date());

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\"" + ":\"Cadastrado\"}").build();
            } else {
                return Response.status(501).entity("{\"result\" : \"Erro no Cadastro\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }
    }

    @DELETE
    @Path("/deleteusuario")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(InputStream dadosServ) {
        StringBuilder requisicaoFinal = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);
            }
            System.out.println(requisicaoFinal.toString());
            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            System.out.println("" + resposta.getInt("idUsuario"));
            int idUsuario = resposta.getInt("idUsuario");
            if (new UsuarioController().deleteUsuario(idUsuario)) {
                return Response.status(200).entity("{\"result\": \"sucesso\"}").build();
            } else {
                return Response.status(501).entity("{\"result\": \"error\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();

        }

    }
}
