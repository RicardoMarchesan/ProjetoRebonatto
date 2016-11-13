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
public class Detector {

    public static void main(String[] args) throws Exception {
        DatagramSocket soc;
        DatagramPacket pacote;
        InetAddress IPAdress;
        String msg;
        int port = 2006;
        int tmp;

        byte[] receiveData = new byte[1024];  // copiei do server do psiu
        byte[] sendData = new byte[1024];      // copiei do server do psiu 

        System.out.println("Digite o tempo em segundos para detectar falhas: ");
        Scanner input = new Scanner(System.in);
        tmp = input.nextInt();
        tmp = tmp * 1000; //converter ms em s

        while (true) {

            try {
                Thread.sleep(tmp); //usado para definir de quanto em quanto tempo vai fazer a verificação
            } catch (Exception e) {
                System.out.println("Erro na execução do tempo.");
            }
            //System.out.println("Servidor");
            soc = new DatagramSocket();
            msg = "404#";
            sendData = new byte[1024];
            sendData = msg.getBytes();
            IPAdress = InetAddress.getByName("localhost");
            pacote = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            soc.send(pacote);
            System.out.println("Servidor esta vivo? ");

            try {
            pacote = new DatagramPacket(receiveData, receiveData.length);
            soc.setSoTimeout(1000);  //tempo sem resposta para declarar servidor morto
            soc.receive(pacote);
                       String msgresposta = new String(pacote.getData());
            System.out.println(msgresposta);
         //   if (msgresposta.equals("Alive!"))
                System.out.println("server vivo! ");
         //   else System.out.println("Verifique Servidor morreu");
            soc.close();
            
            }catch (Exception e){
                System.out.println("Servidor morreu, verifique");
            }
            
            
            }

        }
    }


