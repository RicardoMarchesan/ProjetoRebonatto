/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSoap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.Random;
import javax.swing.JOptionPane;
import url.banco.BelasMensagens;
import url.banco.Operacoes;

/**
 *
 * @author Guilherme Paim
 */
//@WebService(endpointInterface = "ServerSoap.Ctrl")
// @SOAPBinding(style = SOAPBinding.Style.RPC)

public class Ctrl {

    public BelasMensagens Consultar(int id)
    {
        BelasMensagens f = new BelasMensagens();
        f.setCodigo(0);
        try
        {
            f = Operacoes.consultaMsg(id);
        }
        catch (Exception E)
        {
            
            E.printStackTrace();
            f.setCodigo(-1);
           // f.setBelasMensagens("");
            f.setTipo(0);
            return f;
        }
        return f;
    }
    
    @WebMethod
    public boolean adicionar(int codigo, String mensagem, int tipo)
    {
        try
        {
            BelasMensagens bm=new BelasMensagens();
            bm.setCodigo(codigo);
            bm.setMensagem(mensagem);
            bm.setTipo(tipo);
            Operacoes.adicionaMsg(bm);
        }
        catch(Exception E)
        {
            
            E.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    @WebMethod
    public boolean alterar(int Codigo, String mensagem, int tipo)
    {
        try
        {
            //Operacoes.consultaMsg(Codigo);
            BelasMensagens bm=new BelasMensagens();

            bm=Operacoes.consultaMsg(Codigo);
            
            //Operacoes.alteraMsg(bm.setCodigo(Codigo), bm.setMensagem(mensagem),bm.setTipo(tipo));
            
            Operacoes.alteraMsg(bm);
        }
        catch(Exception E)
        {
            
            E.printStackTrace();
            return false;
        }
        return true;
    }
    
    @WebMethod
    public boolean excluir(int Codigo)
    {
        try
        {
           BelasMensagens bm=new BelasMensagens();
           bm=Operacoes.consultaMsg(Codigo);
           Operacoes.deletaMsg(bm);
        }
        catch(Exception E)
        {
            
            E.printStackTrace();
            return false;
        }
        return true;
    }
    
    @WebMethod
    public BelasMensagens[] listaTipo(int categoria)
    {
        try
        {
            if(categoria < 1 || categoria > 8)
                 throw new Exception();
            return Operacoes.listaMsgInt(categoria);
        }
        catch(Exception E)
        {
            
            E.printStackTrace();
            BelasMensagens[]f = new BelasMensagens[0];
            return f; 
        }
    }
    
    @WebMethod
    public BelasMensagens mensagemAleatoria(int categoria)
    {
        try
        {
            if(categoria < 1 || categoria > 8)
                 throw new Exception();
            
            BelasMensagens[] belasMensagenses = Operacoes.consultaTipo(categoria);
            Random R = new Random();
            int frasesl = belasMensagenses.length;
            int aleatorio = R.nextInt(belasMensagenses.length); 
            return belasMensagenses[aleatorio];
        }
        catch(Exception E)
        {
            
            BelasMensagens f = new BelasMensagens();
            E.printStackTrace();
            f.setCodigo(-1);
            return f;
        }
    }
    
}
