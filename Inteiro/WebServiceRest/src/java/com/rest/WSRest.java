/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import controler.Operacoes;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.BelasMensagens;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author marina
 */
@Path("/wsrest")
public class WSRest {

    @Context
    private UriInfo context;
    public static ArrayList<BelasMensagens> lista = new ArrayList<>();
    
    /**
     * Creates a new instance of WebServiceRest
     */
    public WSRest() {
      
        
    }

    /**
     * Retrieves representation of an instance of com.rest.WebServiceRest
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getJson(@javax.ws.rs.PathParam("id") int id) throws SQLException {
           System.out.println("chegou");
            JSONObject obj = new JSONObject();
	    BelasMensagens bm = new BelasMensagens();
            Operacoes op = new Operacoes();
            bm = op.consultaMsg(id);
	    obj.put("id", bm.getCodigo());
            obj.put("mensagem", bm.getMensagem());
            obj.put("tipo", bm.getTipo());
                			
            
            System.out.println(obj.toString());
            return obj.toString();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BelasMensagens> getlista() throws SQLException {

        Operacoes op = new Operacoes();
        return op.listaMsg();
        
    }

    /**
     * PUT method for updating or creating an instance of WebServiceRest
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("adicionamsg")
    public void postJson(String j) throws SQLException {
        Operacoes op = new Operacoes();
        System.out.println("String json chegou:" + j);
        JSONObject my_obj = new JSONObject(j);
        BelasMensagens blmsg = new BelasMensagens();
        blmsg.setCodigo(my_obj.getInt("id"));
        blmsg.setMensagem(my_obj.getString("mensagem"));
	blmsg.setTipo(my_obj.getInt("tipo"));
        op.adicionaMsg(blmsg);
    }
    
    @Path("/excluirmsg/{codigo}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteMsg(@PathParam("codigo") Integer codigo) throws SQLException {
        
        Operacoes op = new Operacoes();
        Character flag = jaExiste(codigo);
        if (flag == 'n') {

            try {
                System.out.println("Carro de código " + codigo + " não encontrado para exclusão da base de dados.");
            } catch (Exception e) {
                
            }

            return "existe";

        } else {
            
            BelasMensagens blm = new  BelasMensagens();
               blm.setCodigo(codigo);
            
                Operacoes.deletaMsg(blm);
                System.out.println("Mensagem excluida com sucesso");
            
            
        }
        return null;
        

    }
    
    @Path("/alterarmsg/{codigo}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String alteramsg(@PathParam("codigo") Integer codigo) throws SQLException{
            
	    BelasMensagens bm = new BelasMensagens();
            Operacoes op = new Operacoes();
            bm.setCodigo(codigo);
            op.alteraMsg(bm);
	    
        
        return null;
        
    }

    public Character jaExiste(Integer codigo) throws SQLException {
        Character flag = 'n';

        List<BelasMensagens> todosmsg =new  ArrayList<BelasMensagens>();

        Iterator it = todosmsg.iterator();

        while (it.hasNext()) {
            BelasMensagens msgIt = (BelasMensagens) it.next();

            if (Objects.equals(codigo, msgIt.getCodigo())) {
                flag = 's';
            }
        }

        return flag;
    }

   
}
