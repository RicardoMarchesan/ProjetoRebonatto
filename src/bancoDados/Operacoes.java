/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDados;

import construtor.BelasMensagens;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Djessica
 */
public class Operacoes {
    
    public static void adicionaMsg(BelasMensagens BLmsg) throws SQLException{
        String sql = "insert into bl_mensagens (codigo,mensagem,tipo) values (?,?,?)";
        PreparedStatement stm = Conexao.getPrepared(sql);
        stm.setInt(1, BLmsg.getCodigo());
        stm.setString(2,BLmsg.getMensagem());
        stm.setInt(3,BLmsg.getTipo());
        stm.executeUpdate(); 
    }
    public static void deletaMsg(BelasMensagens Blmsg) throws SQLException{
        String sql = "delete from bl_mensagens where codigo = ?";
        PreparedStatement stm = Conexao.getPrepared(sql);
        stm.setInt(1,Blmsg.getCodigo());
        stm.executeUpdate();
    }
    
    public static void alteraMsg(BelasMensagens Blmsg) throws SQLException{
        String sql = "update bl_mensagens set mensagem = ?, tipo = ? where codigo = ?";
        PreparedStatement stm = Conexao.getPrepared(sql);
        stm.setString(1,Blmsg.getMensagem());
        stm.setInt(2,Blmsg.getTipo());
        stm.setInt(3,Blmsg.getCodigo());
        stm.executeUpdate();
    }
    public static BelasMensagens consultaMsg(Integer cod) throws SQLException{
        BelasMensagens blmsg = new BelasMensagens();
        Statement stm = Conexao.statement();
        ResultSet resul = stm.executeQuery("select * from bl_mensagens where codigo = " + cod );
        
        resul.next();
        if (!resul.wasNull()){
            blmsg.setCodigo(resul.getInt("codigo"));
            blmsg.setMensagem(resul.getString("mensagem"));
            blmsg.setTipo(resul.getInt("tipo"));
        }
        
        return blmsg;
        
    }
}
