/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDados;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author djess
 */
public class Conexao {

    public Statement stm;//responsavel por preparar e realizar pesquisa no banco
    public ResultSet rs;//responsavel por armazenar o resulatdo de uma pesquisa
    //private String drive = "org.postgresql.Driver"; //identifica o banco de dados que esta usando
    static String caminho = "jdbc:postgresql://localhost:5433/BelasMensagens";//porta do postgres
    static String usuario = "postgres";
    static String senha = "masterkey";
    static Connection conn;

    public static Connection conecta() throws SQLException {
        try {//carrega o drive postgre
            Class.forName("org.postgresql.Driver");
            
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //System.out.println("oiii");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!" + e);
        }
        return conn;
    }

    public static PreparedStatement getPrepared(String sql) throws SQLException {
        try {
            return conecta().prepareStatement(sql);
        } catch (Exception e1) {
            System.out.println("Erro ao preparar a instrução SQL!");
            return null;
        }

    }
    public static Statement statement (){
        try {
          return conecta().createStatement();
        } catch (Exception e2) {
           System.out.println("Erro ao criar statement");  
           return null;
        }
   
    }
}
