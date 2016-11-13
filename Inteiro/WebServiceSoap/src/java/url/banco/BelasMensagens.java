/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url.banco;

import java.io.Serializable;

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
    
    
    public void setBelasMensagens(int codigo, String mensagem, int tipo) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.tipo = tipo;         
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
