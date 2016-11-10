/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author rebonatto
 */
public class Servidor {
    public static void main(String[] args) throws Exception{
        DatagramSocket soc;
        DatagramPacket pct;
        byte vet[];
        String msg;
        int porta;
        InetAddress adress;
        
        System.out.println("Servidor");
        porta = 2006;
        soc = new DatagramSocket(porta);
        vet = new byte[100];
        pct = new DatagramPacket(vet, vet.length);
        soc.receive(pct);
        System.out.println("Recebeu Mensagem");
        msg = new String(pct.getData());
        System.out.println("Conteudo: " + msg);
        
        
        msg = msg.toUpperCase();
        vet = new byte[100];
        vet = msg.getBytes();
        adress = pct.getAddress();
        porta = pct.getPort();
        pct = new DatagramPacket(vet, vet.length, adress, porta);
        soc.send(pct);
        
        JOptionPane.showMessageDialog(null,new String(pct.getData()).trim(),
	       "Chegou",1);
        soc.close();      
        
    }
    
}