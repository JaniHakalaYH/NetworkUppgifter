package Uppgift12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPChat {

    public static void main(String[] args) {

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(1337);) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}