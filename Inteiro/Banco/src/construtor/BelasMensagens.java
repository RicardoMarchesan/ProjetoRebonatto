/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construtor;

import java.io.Serializable;

/**
 *
 * @author Djessica
 */
public class BelasMensagens implements Serializable{//vai transferir via socket 
    
    private int codigo;
    private String mensagem;
    private int tipo;

    public BelasMensagens() {
    }

    public BelasMensagens(int codigo, String mensagem, int tipo) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.tipo = tipo;
    }

    public BelasMensagens(String msgcod, String msg, String tipomsg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
  
    
    
}
