/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectorFalhas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VerificaServidor extends Thread {

    public void run() {
         
        DatagramSocket soc = null;
        DatagramPacket pacote;
        InetAddress IPAdress;
        String msg;
        String msg2;
        String host = ("localhost");
        int port = 2006;
        int tmp; // tempo de verificação do servidor
        byte[] receiveData = new byte[1024];  // copiei do server do psiu
        byte[] sendData = new byte[1024];      // copiei do server do psiu 

        System.out.println("Digite primeiro o tempo em segundos para verificar o servidor: ");
        Scanner input = new Scanner(System.in);
        tmp = input.nextInt();
        tmp = tmp * 1000; //converter ms em s

        while (true) {
            try {
                Thread.sleep(tmp); //usado para definir de quanto em quanto tempo vai fazer a verificação
            } catch (Exception e) {
                System.out.println("Erro na execução do tempo.");
            }
            /*
            try {
            
                //verificar server em TCP mas não rolou pq o psiu recebia UDP
                    Socket soc2;
                    ObjectOutputStream escreve;
                    //String host = new String("localhost");
                    msg2 = ("404#");
                    int porta = 2006;
                    System.out.println("Cliente");
                    soc2 = new Socket(host, porta);
                    escreve = new ObjectOutputStream(soc2.getOutputStream());
                    escreve.writeObject(msg2);
                    escreve.flush();
                    soc.close(); 
                    
            } catch (Exception e) {
                System.out.println(e);
            }
            */
            //  fiz em UDP achando que era tcp.
            try {
                //System.out.println("Servidor");
                soc = new DatagramSocket();
                IPAdress = InetAddress.getByName("localhost");  //trocar pelo ip da maquina
                pacote = new DatagramPacket(sendData, sendData.length, IPAdress, port);
                soc.send(pacote);
                System.out.println("Servidor esta vivo? ");
            } catch (SocketException ex) {
                Logger.getLogger(VerificaServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(VerificaServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VerificaServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            msg = "404#";
            sendData = msg.getBytes();

            try {
                pacote = new DatagramPacket(receiveData, receiveData.length);
                soc.setSoTimeout(1000);  //tempo sem resposta para declarar servidor morto em ms
                soc.receive(pacote);
                String msgresposta = new String(pacote.getData());
                System.out.println(msgresposta);
                //   if (msgresposta.equals("Alive!"))
                System.out.println("server vivo! ");
                //   else System.out.println("Verifique Servidor morreu");
                soc.close();

            } catch (Exception e) { 
                System.out.println("Servidor morreu, verifique");
            } 
        }
        }
    }
