/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSoap;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Guilherme Paim
 */
public class Server {
    
    
    public static void main(String[] args) {
        //Copiei ideia do kressin
        String ip = JOptionPane.showInputDialog("Informe o endereço IP, ou localhost?");
        String url = "http://" + ip + "/soap/";
        
        try
        {
            Endpoint.publish(url, new Ctrl());  //publica o server
            JOptionPane.showMessageDialog(null, "Servidor iniciado\nURL: " + url + "?WSDL");
        }
        catch(Exception E)
        {
            JOptionPane.showMessageDialog(null, "não iniciou server");
            E.printStackTrace();
        }
    }
    
}
