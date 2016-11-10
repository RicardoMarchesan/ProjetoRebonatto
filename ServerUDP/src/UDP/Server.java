/*
 Servidor que aceita requisições por meio de um Socket UDP, porta 2006
 */
package UDP;

import java.io.*;
import java.net.*;

/**
 *
 * @author psiuzin
 */
public class Server {
    public static void main(String args[]) throws Exception
      {
         DatagramSocket serverSocket = new DatagramSocket(2006);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while(true)
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String(receivePacket.getData());
                  System.out.println("Received: " + sentence);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  //String capitalizedSentence = sentence.toUpperCase();
                  sendData = sentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
               }
      }
}
