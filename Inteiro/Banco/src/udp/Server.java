/*
 Servidor que aceita requisições por meio de um Socket UDP, porta 2006
 */
package udp;

import java.io.*;
import java.net.*;
import bancoDados.*;
import construtor.*;

/**
 *
 * @author psiuzin
 */

//1 Adiciona
//2 Altera
//3 Exclui
//4 Consulta
//5 ListaTipo
//6 Mensagem Aleatória de Tipo

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
                  String[] split = sentence.split("&");
                  char tipoop = split[0].charAt(0);
                  String msg = split[1];
                  int msgcod = Integer.parseInt(split[2]);
                  int tipomsg = Integer.parseInt(split[3]);
                  BelasMensagens bmsg = new BelasMensagens(msgcod, msg, tipomsg);
                  
                  switch(tipoop) {
                      case '1': // Adiciona
                          Operacoes.adicionaMsg(bmsg);
                          System.out.println("Adiciona");
                          break;
                      case '2': // Altera
                          Operacoes.alteraMsg(bmsg);
                          System.out.println("Altera");
                          break;
                      case '3': // Exclui
                          Operacoes.deletaMsg(bmsg);
                          System.out.println("Exclui");
                          break;
                      case '4': // Consulta
                          Operacoes.consultaMsg(bmsg.getCodigo());
                          System.out.println("Consulta");
                          break;
                      case '5': // ListaTipo
                          Operacoes.consultaTipo(tipomsg);
                          System.out.println("Lista Tipo");
                          break;
                      case '6': // Msg Aleatória Tipo
                          Operacoes.listamsg(tipomsg);
                          System.out.println("Mensagem Aleatória de tal Tipo");
                          break;
                      default:
                          System.out.println("Operação não válida");
                  }
                  
                  
                  
                  
                  
                  
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  //String capitalizedSentence = sentence.toUpperCase();
                  sendData = msg.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
               }
      }
}
