/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author djess
 */
public class Conexao {
   public  Statement stm;//responsavel por preparar e realizar pesquisa no banco
   public  ResultSet rs;//responsavel por armazenar o resulatdo de uma pesquisa
   private String drive = "org.postgresql.Driver"; //identifica o banco de dados que esta usando
   private String caminho = "jdbc:postgresql://localhost:5433/BelasMensagens";//porta do postgres
   private String usuario = "postgres";
   private String senha = "masterkey";
   public  Connection conn;
     
   public void conecta(){
       try {
           System.setProperty("jdbc.Drivers",drive);//seta a propriedade do drive de conexao
           conn = DriverManager.getConnection(caminho, usuario, senha);//realiza a conexao
           JOptionPane.showMessageDialog(null,"Conectado com sucesso");
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão" + ex.getMessage());
       }
   }
   public void desconecta (){
       try {
           conn.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão" + ex.getMessage());
       }
   }
}
