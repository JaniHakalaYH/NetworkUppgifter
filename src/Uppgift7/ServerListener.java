package Uppgift7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
    public ServerListener(){

        try (ServerSocket serverSocket = new ServerSocket(1337);) {
            while (true) {
                Socket s = serverSocket.accept();
                TelefonServer serv = new TelefonServer(s);
                serv.start();
            }

    }catch (IOException e) {
        e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        ServerListener s1 = new ServerListener();
    }
}
