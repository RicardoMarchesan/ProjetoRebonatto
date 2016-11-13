/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url.banco;



import java.sql.SQLException;

public class Teste {
     
    public static void main(String[] args) throws SQLException {
     Conexao conecta = new Conexao();
     conecta.conecta();
        BelasMensagens bm = new BelasMensagens(3, "Exemplo 3 ", 5);
        Operacoes op = new Operacoes();
        op.adicionaMsg(bm);
      
    }
}
