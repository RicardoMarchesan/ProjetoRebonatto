/*
 Servidor que aceita requisições por meio de um Socket UDP, porta 2006
 */
package udp;

import java.io.*;
import java.net.*;
import bancoDados.*;
import construtor.*;
import java.util.List;

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
        DatagramSocket serverSocket = new DatagramSocket(2006);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        String tipoop = new String();

        String logstring = new String();
        String[] split;
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData()); // Recebi o tamanho da mensagem
            String msg = new String();
            BelasMensagens bmsg = new BelasMensagens();

            split = sentence.split("#");
            int qtdmsg = Integer.parseInt(split[0]);

            if (qtdmsg == 404) {
                tipoop = "404";
            } else {

                if (qtdmsg == 1) // Se a mensagem for de tamanho 1 packet, faço tudo normalmente
                {
                    serverSocket.receive(receivePacket);
                    sentence = new String(receivePacket.getData());
                    split = sentence.split("#");
                    if (split.length > 1) //Splitei, se houve split é o conjunto de dados
                    {
                        tipoop = split[0];
                        int msgcod = Integer.parseInt(split[1]);
                        int tipomsg = Integer.parseInt(split[2]);
                        bmsg.setCodigo(msgcod);
                        bmsg.setTipo(tipomsg);
                    } else {
                        msg += split[0]; // Se não houve split, é a BelaMSG
                        bmsg.setMensagem(msg);
                    }
                } else // Mensagem maior que 1 packet
                {
                    int tam = Character.getNumericValue(sentence.charAt(0)); // Pego o tamanho da mensagem
                    for (int i = 0; i < tam; i++) // Fico recebendo a mensagem
                    {
                        serverSocket.receive(receivePacket);
                        sentence = new String(receivePacket.getData());
                        split = sentence.split("#");
                        if (split.length > 1) //Splitei, se houve split é o conjunto de dados
                        {
                            tipoop = split[0];
                            int msgcod = Integer.parseInt(split[1]);
                            int tipomsg = Integer.parseInt(split[2]);
                            bmsg.setCodigo(msgcod);
                            bmsg.setTipo(tipomsg);
                        } else {
                            msg += split[0]; // Se não houve split, é a BelaMSG;
                        }
                    }
                    bmsg.setMensagem(msg); // Mensagem concatenada completa
                }
            }
            // A partir desse momento o objeto BelaMensagem é pra estar pronto

            //BelasMensagens bmsg = new BelasMensagens(msgcod, msg, tipomsg);
//            while (sentence.charAt(0) == 8) {
//                String pac = new String();
//                pac += sentence.substring(1, sentence.length());
//                receivePacket = new DatagramPacket(receiveData, receiveData.length);
//
//            }
//            System.out.println("Received: " + sentence);
//            String[] split = sentence.split("&");
//            char tipoop = split[0].charAt(0);
//            msg = split[1];
//            int msgcod = Integer.parseInt(split[2]);
//            int tipomsg = Integer.parseInt(split[3]);
//            BelasMensagens bmsg = new BelasMensagens(msgcod, msg, tipomsg);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String msgresposta = new String();
            DatagramPacket sendPacket;
            BelasMensagens bmsg2 = new BelasMensagens();

            int operacao = Integer.parseInt(tipoop);
            switch (operacao) {
                case 404: // requisição se está vivo
                    System.out.println("Tô vivo");
                    String alive = new String("Alive!");
                    sendData = alive.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket);
                    break;
                case 1: // Adiciona
                    Operacoes.adicionaMsg(bmsg);
                    try {

                        //String content = "This is the content to write into file";
                        logstring = "O ip " + receivePacket.getAddress().toString()
                                + "adicionou a mensagem de código" + bmsg.getCodigo()
                                + "ao banco de dados.";
                        File file = new File("logalteracoes.txt");

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(logstring);
                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.out.println("Adiciona");
                    break;
                case 2: // Altera
                    Operacoes.alteraMsg(bmsg);
                    try {

                        //String content = "This is the content to write into file";
                        logstring = "O ip " + receivePacket.getAddress().toString()
                                + "alterou a mensagem de código" + bmsg.getCodigo()
                                + "ao banco de dados.";
                        File file = new File("logalteracoes.txt");

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(logstring);
                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    System.out.println("Altera");
                    break;
                case 3: // Exclui
                    Operacoes.deletaMsg(bmsg);
                    try {

                        //String content = "This is the content to write into file";
                        logstring = "O ip " + receivePacket.getAddress().toString()
                                + "excluiu a mensagem de código" + bmsg.getCodigo()
                                + "ao banco de dados.";
                        File file = new File("logalteracoes.txt");

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(logstring);
                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    System.out.println("Exclui");
                    break;
                case 4: // Consulta
                    bmsg2 = Operacoes.consultaMsg(bmsg.getCodigo());
                    split = splitByNumber(bmsg2.getMensagem(), 110);
//                    System.out.println("Consulta");
                    msgresposta = Integer.toString(split.length) + "#";
                    sendData = msgresposta.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket); // Enviei quantos packets serão necessários para receber a mensagem

                    for (int i = 0; i < split.length; i++) {
                        msgresposta = split[i];
                        sendData = msgresposta.getBytes();
                        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                        serverSocket.send(sendPacket);
                    } // Envio todos os pacotes da mensagem
                    
                    try {

                        //String content = "This is the content to write into file";
                        logstring = "O ip " + receivePacket.getAddress().toString()
                                + "consultou a mensagem de código" + bmsg2.getCodigo()
                                + "no banco de dados.";
                        File file = new File("logalteracoes.txt");

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(logstring);
                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5: // ListaTipo
                    List<BelasMensagens> lista;
                    lista = Operacoes.listamsg(bmsg.getTipo());
                    //System.out.println("Lista Tipo");
                    msgresposta = Integer.toString(lista.size()) + "#";
                    sendData = msgresposta.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket); // Enviei quantas mensagens tem na lista
                    for (int i = 0; i < lista.size(); i++) {
                        bmsg2 = lista.get(i);
                        split = splitByNumber(bmsg2.getMensagem(), 110);
                        msgresposta = Integer.toString(split.length) + "#";
                        sendData = msgresposta.getBytes();
                        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                        serverSocket.send(sendPacket); // Enviei quantos packets serão necessários para receber a mensagem

                        for (int j = 0; j < split.length; j++) {
                            msgresposta = split[i];
                            sendData = msgresposta.getBytes();
                            sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                            serverSocket.send(sendPacket);
                        } // Envio todos os pacotes da mensagem
                    }
                    
                    try {

                        //String content = "This is the content to write into file";
                        logstring = "O ip " + receivePacket.getAddress().toString() +
                                "consultou mensagens do tipo" + bmsg.getTipo()
                                + "no banco de dados.";
                        File file = new File("logalteracoes.txt");

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(logstring);
                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6: // Msg Aleatória Tipo
                    bmsg2 = Operacoes.consultaTipo(bmsg.getTipo());
                    split = splitByNumber(bmsg2.getMensagem(), 110);
                   // System.out.println("Consulta");
                    msgresposta = Integer.toString(split.length) + "#";
                    sendData = msgresposta.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket); // Enviei quantos packets serão necessários para receber a mensagem

                    for (int i = 0; i < split.length; i++) {
                        msgresposta = split[i];
                        sendData = msgresposta.getBytes();
                        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                        serverSocket.send(sendPacket);
                    } // Envio todos os pacotes da mensagem
                    //System.out.println("Mensagem Aleatória de tal Tipo");
                    try {

                        //String content = "This is the content to write into file";
                        logstring = "O ip " + receivePacket.getAddress().toString() +
                                "consultou uma mensagem aleatória do tipo" + bmsg.getTipo()
                                + "no banco de dados.";
                        File file = new File("logalteracoes.txt");

                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(logstring);
                        bw.close();

                        System.out.println("Done");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Operação não válida");
            }

//            InetAddress IPAddress = receivePacket.getAddress();
//            int port = receivePacket.getPort();
//            String capitalizedSentence = sentence.toUpperCase();
//            sendData = msg.getBytes();
//            DatagramPacket sendPacket
//                    = new DatagramPacket(sendData, sendData.length, IPAddress, port);
//            serverSocket.send(sendPacket);
        }
    }
}
