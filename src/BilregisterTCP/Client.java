package BilregisterTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Serializable {

    public Client() throws ClassNotFoundException {
        try(
                Socket socket = new Socket("127.0.0.1",1337);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        ){
            String fromUser;
            Object fromServer;
            fromServer = input.readObject();
            System.out.println(fromServer);

            while((fromUser = userInput.readLine()) != null){

                output.println(fromUser);
                //System.out.println("Sent to server: "+fromUser);

                fromServer = input.readObject();

                if (fromServer instanceof Bil){
                    Bil b = (Bil) fromServer;
                    System.out.println(b.getOwner()+" "+b.getBrand()+" "+b.getColor()+" "+b.getRegNr());
                }
                else if(fromServer instanceof String){
                    System.out.println(fromServer);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        new Client();
    }
}
