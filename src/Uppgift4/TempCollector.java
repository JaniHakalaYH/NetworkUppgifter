package Uppgift4;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TempCollector extends JFrame {

    JPanel panel = new JPanel();
    JTextArea area = new JTextArea(30,20);

    public TempCollector() throws IOException{

        this.add(panel);
        panel.add(area);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        int port = 1337;
        DatagramSocket socket = new DatagramSocket(port);
        byte[] dataRecieved = new byte[256];
        DatagramPacket packet = new DatagramPacket(dataRecieved, dataRecieved.length);

        while(true) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                area.setText(area.getText() + " " + message + "\n");

        }
    }
   public static void main(String[] args) throws IOException{
        TempCollector tc = new TempCollector();
   }
}
