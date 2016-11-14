/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import controler.Operacoes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("adicionamsg")
    public void putJson(String j) throws SQLException {
        Operacoes op = new Operacoes();
        System.out.println("String json chegou:" + j);
        JSONObject my_obj = new JSONObject(j);
        BelasMensagens blmsg = new BelasMensagens();
        blmsg.setCodigo(my_obj.getInt("id"));
        blmsg.setMensagem(my_obj.getString("mensagem"));
	blmsg.setTipo(my_obj.getInt("tipo"));
        op.adicionaMsg(blmsg);
    }
}
