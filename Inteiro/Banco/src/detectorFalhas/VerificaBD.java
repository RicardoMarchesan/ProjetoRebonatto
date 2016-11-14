/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectorFalhas;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class VerificaBD extends Thread{
    @Override
    public void run(){
        DatagramSocket soc;
        DatagramPacket pacote;
        InetAddress IPAdress;
        String msg;
        int port = 2006;
        int tmp; // tempo de verificação do servidor
        int minutos; // tempo de verificação de duplicidade
        byte[] receiveData = new byte[1024];  // copiei do server do psiu
        byte[] sendData = new byte[1024];      // copiei do server do psiu 

        
        System.out.println("Digite por segundo o tempo em minutos para verificar o banco: ");
        Scanner input2 = new Scanner(System.in);
        minutos = input2.nextInt();
        minutos = (minutos * 1000) * 60; //converter ms em s
    
     while(true){
    try{
        Thread.sleep(minutos);
    } catch(Exception e){
        System.out.println(e + "erro ");
    }
         System.out.println("passou tempo aqui");
    }
     
    }
}
