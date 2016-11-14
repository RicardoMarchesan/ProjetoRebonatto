/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectorFalhas;

/**
 *
 * @author User
 */
public class Detector {

    public static void main(String[] args) throws Exception {     
        
        VerificaServidor verifica = new VerificaServidor();
        Thread threadVerifica = new Thread(verifica);
        threadVerifica.start();
        
        VerificaBD verifica2 = new VerificaBD();
        Thread threadVerifica2 = new Thread(verifica2);
        threadVerifica2.start();
        
        /*   DatagramSocket soc;
        DatagramPacket pacote;
        InetAddress IPAdress;
        String msg;
        int port = 2006;
        int tmp; // tempo de verificação do servidor
        int minutos; // tempo de verificação de duplicidade
        byte[] receiveData = new byte[1024];  // copiei do server do psiu
        byte[] sendData = new byte[1024];      // copiei do server do psiu 

//aqui começa para ver se o server está vivo?

        System.out.println("Digite o tempo em segundos para verificar o servidor: ");
        Scanner input = new Scanner(System.in);
        tmp = input.nextInt();
        tmp = tmp * 1000; //converter ms em s
        
        System.out.println("Digite o tempo em minutos para verificar o banco: ");
        Scanner input2 = new Scanner(System.in);
        minutos = input2.nextInt();
        minutos = (minutos * 1000) * 60; //converter ms em s
        System.out.println(minutos);
        
        while (true) {
            try {
                Thread.sleep(tmp); //usado para definir de quanto em quanto tempo vai fazer a verificação
            } catch (Exception e) {
                System.out.println("Erro na execução do tempo.");
            }
            //System.out.println("Servidor");
            soc = new DatagramSocket();
            msg = "404#";
            sendData = msg.getBytes();
            IPAdress = InetAddress.getByName("localhost");
            pacote = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            soc.send(pacote);
            System.out.println("Servidor esta vivo? ");

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
        // aqui para verificar duplicidade
        
        }  */

    }

    

    }
    
   /* public class verificaServid extends Thread {

        public void run() {

        }
    }*/
