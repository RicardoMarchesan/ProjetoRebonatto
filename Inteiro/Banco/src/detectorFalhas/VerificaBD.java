/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectorFalhas;

import bancoDados.Conexao;
import construtor.BelasMensagens;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VerificaBD extends Thread {

    @Override
    public void run() {
        DatagramSocket soc;
        DatagramPacket pacote;
        InetAddress IPAdress;
        String msg;
        int port = 2006;
        int minutos; // tempo de verificação de duplicidade
        byte[] receiveData = new byte[1024];  // copiei do server do psiu
        byte[] sendData = new byte[1024];      // copiei do server do psiu 

        System.out.println("Digite por segundo o tempo em minutos para verificar o banco: ");
        Scanner input2 = new Scanner(System.in);
        minutos = input2.nextInt();
        minutos = (minutos * 1000) * 60; //converter ms em s

        while (true) {
            try {
                //tempo em minutos para executar a thread
                Thread.sleep(minutos);
            } catch (InterruptedException e) {
                System.out.println(e + "erro ");
            }
            //detectar mensagens duplicadas aqui....
            try {
                
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        
        }

}
}
