package Uppgift3;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class Reciever implements Runnable{
    Thread aktivitet = new Thread(this);
    MulticastSocket multiSocket;
    JTextArea txt;

    Reciever (MulticastSocket sock, JTextArea txtAr){
        multiSocket = sock;
        txt = txtAr;
        aktivitet.start();
    }

    public void run(){
        byte[] data = new byte[1024];
        while(true){
            try{
                DatagramPacket packet = new DatagramPacket
                        (data, data.length);
                multiSocket.receive(packet);
                String medd = new String(data, 0,
                        packet.getLength());
                synchronized(this) {
                    txt.append(medd +"\n");
                }
            }
            catch (IOException e){
                break;
            }
        }
    }
}
