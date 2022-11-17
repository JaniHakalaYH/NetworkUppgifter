package BilregisterTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Serializable{

    Database db = new Database();

    public Server() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(1337);
            Socket socket = serverSocket.accept();
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        ){

            output.writeObject("Hej och välkommen! Skriv in ett regnummer: ");
            String clientRequest = "";

            while((clientRequest = input.readLine()) != null){
                Bil dbAnswer = db.search(clientRequest.trim());
                if(dbAnswer == null){
                    output.writeObject("Bilen kunde inte hittas!");
                }
                output.writeObject(dbAnswer);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        new Server();
    }
}
