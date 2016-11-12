/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import controler.Conexao;
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
        BelasMensagens bm = new BelasMensagens();
        bm.setBelasMensagens(1, "Mensagem teste", 1);
        lista.add(bm);
        
    }

    /**
     * Retrieves representation of an instance of com.rest.WebServiceRest
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getJson(@javax.ws.rs.PathParam("id") int id) {
        
    JSONObject obj = new JSONObject();
	    
	    for ( BelasMensagens bm : lista){
		if(bm.getCodigo()==id){
                    obj.put("mensagem", bm.getMensagem());
		    obj.put("tipo", bm.getTipo());
                }			
            }
		return obj.toString();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getlista() throws SQLException {

        Operacoes op = new Operacoes();
        System.out.println("chegou" + op.listaMsg().toString());
        return op.listaMsg();
        
    }

    /**
     * PUT method for updating or creating an instance of WebServiceRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
