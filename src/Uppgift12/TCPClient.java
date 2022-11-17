package Uppgift12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient extends JFrame implements ActionListener {

    JTextArea area = new JTextArea();
    JScrollPane scroll = new JScrollPane(area);
    JTextField write = new JTextField();
    String name = "";

    PrintWriter output;

    public TCPClient(){
        name = JOptionPane.showInputDialog(null, "Ange ditt chatt-alias");
        setTitle("Chat "+name);
        area.setEditable(false);
        add(scroll, BorderLayout.CENTER);
        add(write, BorderLayout.SOUTH);
        write.addActionListener(this);
        setSize(400, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String hostName = "127.0.0.1";
        int port = 1337;

        try(
            Socket socket = new Socket(hostName, port);
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));){

            String fromServer;

            while((fromServer = input.readLine()) != null)
                area.append(fromServer +"\n");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        output.println(name+": "+write.getText());
        write.setText("");
    }
    public static void main(String[] args){
        TCPClient client = new TCPClient();
    }
}
