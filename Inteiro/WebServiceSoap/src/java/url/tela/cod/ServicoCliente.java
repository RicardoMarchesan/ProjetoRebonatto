/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url.tela.cod;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import url.banco.BelasMensagens;
import url.banco.Conexao;
import url.banco.Operacoes;

/**
 *
 * @author Jader
 */
@WebService(serviceName = "ServicoCliente")
@Stateless()
public class ServicoCliente {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "adicionarMensagem")
    public BelasMensagens adicionarMensagem(@WebParam(name = "codigo") int codigo, @WebParam(name = "mensagem") String mensagem, @WebParam(name = "tipo") int tipo) throws IOException {
        //TODO write your implementation code here:
        Operacoes op= new Operacoes();
        BelasMensagens bm=new BelasMensagens();
        bm.setCodigo(codigo);
        bm.setMensagem(mensagem);
        bm.setTipo(tipo);
        //op.adicionaMsg(bm);
        return bm;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "alteraMensagem")
    public BelasMensagens alteraMensagem(@WebParam(name = "codigo") int codigo, @WebParam(name = "mensagem") String mensagem, @WebParam(name = "tipo") int tipo) throws IOException {
        //TODO write your implementation code here:
        Operacoes op= new Operacoes();
        BelasMensagens bm=new BelasMensagens();
        bm.setCodigo(codigo);
        bm.setMensagem(mensagem);
        bm.setTipo(tipo);
        //op.alteraMsg(bm);
        return bm;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "excluiMensagem")
    public BelasMensagens excluiMensagem(@WebParam(name = "codigo") int codigo) throws IOException {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "consultaMensagem")
    public BelasMensagens consultaMensagem(@WebParam(name = "codigo") int codigo) throws IOException {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listaTipo")
    public List listaTipo(@WebParam(name = "codigo") int codigo) throws IOException {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "aleatoriaMensagem")
    public BelasMensagens aleatoriaMensagem(@WebParam(name = "tipo") int tipo) throws IOException {
        //TODO write your implementation code here:
        return null;
    }


    
    
    
}
