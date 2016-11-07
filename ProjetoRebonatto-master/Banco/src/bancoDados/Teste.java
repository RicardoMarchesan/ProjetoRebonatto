/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDados;

import java.sql.SQLException;

/**
 *
 * @author djess
 */
public class Teste {
     
    public static void main(String[] args) throws SQLException {
     Conexao conecta = new Conexao();
     conecta.conecta();
        System.out.println("teste commit");
      
    }
}
