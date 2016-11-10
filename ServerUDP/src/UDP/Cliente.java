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
public class Cliente {
    public static void main(String[] args) throws Exception{
        DatagramSocket soc;
        DatagramPacket pct;
        byte vet[];
        String msg;
        int porta = 2006;
        InetAddress adress;
        
        System.out.println("Cliente");
        soc = new DatagramSocket();
        msg = new String("Hello World UDP");
        vet = msg.getBytes();
        adress = InetAddress.getLocalHost();
        pct = new DatagramPacket(vet, vet.length, adress, porta);
        soc.send(pct);
        System.out.println("Enviou mensagem");
             
        pct = new DatagramPacket(vet, vet.length);
        soc.receive(pct);
               
        JOptionPane.showMessageDialog(null,new String(pct.getData()).trim(),
	       "Voltou",1);
        soc.close(); 
    }
    
}