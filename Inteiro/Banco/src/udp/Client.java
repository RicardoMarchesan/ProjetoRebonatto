/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import construtor.BelasMensagens;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author psiuzin
 */
public class Client {

    private static String[] splitByNumber(String s, int size) { // Separa uma string em várias string de tamanho X
        if (s == null || size <= 0) {
            return null;
        }
        int chunks = s.length() / size + ((s.length() % size > 0) ? 1 : 0);
        String[] arr = new String[chunks];
        for (int i = 0, j = 0, l = s.length(); i < l; i += size, j++) {
            arr[j] = s.substring(i, Math.min(l, i + size));
        }
        return arr;
    }

    public static void main(String args[]) throws Exception {

        System.out.println("Selecione o tipo de operação que deseja realizar:");
        System.out.println("1- Adicionar mensagem\n"
                + "2- Alterar mensagem\n"
                + "3- Excluir mensagem\n"
                + "4- Consultar mensagem\n"
                + "5- Listar mensagem por tipo\n"
                + "6- Mensagem aleatória conforme tipo\n"
                + "0- sair");
        Scanner input = new Scanner(System.in);
        int opc = input.nextInt();
        String msg = new String();
        String msgcod = new String();
        String tipomsg = new String();
        String[] sendmsg;

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
        String n = new String();
        String enviar = new String();

        DatagramSocket serverSocket = new DatagramSocket(2007);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        String sentence = new String();
        String[] split;
        int qtdmsg;

        switch (opc) {
            case 1: // Adiciona msg
                System.out.println("Digite a mensagem:");
                input = new Scanner(System.in);
                msg = input.nextLine();
                sendmsg = splitByNumber(msg, 110); // Splito a mensagem pra saber se precisa de mais de 1 string
                System.out.println("Digite o código da mensagem:");
                input = new Scanner(System.in);
                msgcod = input.nextLine();
                System.out.println("Digite o tipo da mensagem:");
                input = new Scanner(System.in);
                tipomsg = input.nextLine();
                //System.out.println(sendmsg.length);

                n = new String();
                n = Integer.toString(sendmsg.length) + "#";
                sendData = n.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviei quantas mensagens vou precisar

                enviar = new String();
                enviar += "1#" + msgcod + "#" + tipomsg; // Tipo de operação 1
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviando o conjunto de dados

                for (int i = 0; i < sendmsg.length; i++) {
                    sendData = sendmsg[i].getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                    clientSocket.send(sendPacket);
                }

                System.out.println("Mensagem adicionada.");

                break;
            case 2: // Altera a msg
                System.out.println("Digite a mensagem:");
                input = new Scanner(System.in);
                msg = input.nextLine();
                sendmsg = splitByNumber(msg, 110);
                System.out.println("Digite o código da mensagem:");
                input = new Scanner(System.in);
                msgcod = input.nextLine();
                System.out.println("Digite o tipo da mensagem:");
                input = new Scanner(System.in);
                tipomsg = input.nextLine();
//                System.out.println(sendmsg.length);

                n = new String();
                n = Integer.toString(sendmsg.length) + "#";
                sendData = n.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviei quantas mensagens vou precisar

                enviar = new String();
                enviar += "2#" + msgcod + "#" + tipomsg; // Tipo de operação 2
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviando o conjunto de dados

                for (int i = 0; i < sendmsg.length; i++) {
                    sendData = sendmsg[i].getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                    clientSocket.send(sendPacket);
                }

                System.out.println("Mensagem alterada.");

                break;
            case 3: // Exclui 
                System.out.println("Digite código da msg que deseja excluir:");
                input = new Scanner(System.in);
                msgcod = input.nextLine();

                n = new String();
                n = "1#";
                sendData = n.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviei quantas mensagens vou precisar

                enviar = new String();
                enviar += "3#" + msgcod + "#1"; // Tipo de operação 3
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviando o conjunto de dados

                enviar = "Não tem msg";
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Envia mensagem em branco para acoplar ao padrão de comunicação

                System.out.println("Mensagem excluída.");

                break;
            case 4: // Consultar mensagem
                System.out.println("Digite o código da mensagem que deseja consultar:");
                input = new Scanner(System.in);
                msgcod = input.nextLine();

                n = new String();
                n = "1#";
                sendData = n.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviei quantas mensagens vou precisar

                enviar = new String();
                enviar += "4#" + msgcod + "#1"; // Tipo de operação 4
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviando o conjunto de dados

                enviar = "Não tem msg";
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket);

                // Começo a receber os pacotes da mensagem consultada
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                sentence = new String(receivePacket.getData()); // Recebi o tamanho da mensagem
                msg = new String();
                //BelasMensagens bmsg = new BelasMensagens();

                split = sentence.split("#");
                System.out.println(split[0]);
                qtdmsg = Integer.parseInt(split[0].trim()); // Recebi a quantidade de pacotes necessários p/ a msg

                for (int i = 0; i < qtdmsg; i++) {
                    serverSocket.receive(receivePacket);
                    sentence = new String(receivePacket.getData());
                    msg = new String();
                    msg += sentence;
                }
                System.out.println("Sua mensagem é: " + msg);

                break;
            case 5: // Lista por tipo
                System.out.println("Digite o tipo de mensagem que deseja consultar:");
                input = new Scanner(System.in);
                tipomsg = input.nextLine();

                n = new String();
                n = "1#";
                sendData = n.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviei quantas mensagens vou precisar

                enviar = new String();
                enviar += "5#1#" + tipomsg; // Tipo de operação 5
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviando o conjunto de dados

                enviar = "Não tem msg";
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket);

                // Começo a receber os pacotes da lista consultada
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                sentence = new String(receivePacket.getData()); // Recebi o tamanho da lista
                split = sentence.split("#");
                int tamlista = Integer.parseInt(split[0].trim());

                for (int i = 0; i < tamlista; i++) {
                    receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);
                    sentence = new String(receivePacket.getData()); // Recebi o tamanho da mensagem
                    msg = new String();
                    //BelasMensagens bmsg = new BelasMensagens();

                    split = sentence.split("#");
                    qtdmsg = Integer.parseInt(split[0]); // Recebi a quantidade de pacotes necessários p/ a msg

                    for (int j = 0; j < qtdmsg; j++) {
                        serverSocket.receive(receivePacket);
                        sentence = new String(receivePacket.getData());
                        msg = new String();
                        msg += sentence;
                    }
                    System.out.println("Mensagem " + i + ": " + msg);
                }

                break;
            case 6: // Msg Aleatória por tipo
                System.out.println("Digite o tipo de mensagem que deseja:");
                input = new Scanner(System.in);
                tipomsg = input.nextLine();

                n = "1#";
                sendData = n.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviei quantas mensagens vou precisar

                enviar = new String();
                enviar += "6#1#" + tipomsg; // Tipo de operação 6
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket); // Enviando o conjunto de dados

                enviar = "Não tem msg";
                sendData = enviar.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
                clientSocket.send(sendPacket);

                // Começo a receber os pacotes da mensagem consultada
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                sentence = new String(receivePacket.getData()); // Recebi o tamanho da mensagem
                msg = new String();
                //BelasMensagens bmsg = new BelasMensagens();

                split = sentence.split("#");
                qtdmsg = Integer.parseInt(split[0].trim()); // Recebi a quantidade de pacotes necessários p/ a msg

                for (int i = 0; i < qtdmsg; i++) {
                    serverSocket.receive(receivePacket);
                    sentence = new String(receivePacket.getData());
                    msg = new String();
                    msg += sentence;
                }
                System.out.println("Sua mensagem é: " + msg);

                break;
            case 0:
                System.out.println("Você escolheu sair do programa.");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

//        System.out.println("Digite a mensagem");
//        BufferedReader inFromUser
//                = new BufferedReader(new InputStreamReader(System.in));
//        String sentence = inFromUser.readLine();
//        sendData = sentence.getBytes();
//        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2006);
//        clientSocket.send(sendPacket);
//        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//        clientSocket.receive(receivePacket);
//        String modifiedSentence = new String(receivePacket.getData());
//        System.out.println("Server:" + modifiedSentence);
//        clientSocket.close();
}
