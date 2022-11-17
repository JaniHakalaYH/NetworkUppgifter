package Uppgift12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPChat {

    private static Multiwriter multiWriter = new Multiwriter();

    public static void main(String[] args) throws IOException {

        while (true) {

            try (ServerSocket serverSocket = new ServerSocket(1337);) {
                Socket clientSocket = serverSocket.accept();
                Handler clientHandler = new Handler(clientSocket, multiWriter);
                clientHandler.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}