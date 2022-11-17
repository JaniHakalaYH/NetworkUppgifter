package Uppgift5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TelefonClient {

    private final int port = 1337;

    public TelefonClient() throws UnknownHostException {


        InetAddress address = InetAddress.getByName("127.0.0.1");

        try(Socket socket = new Socket(address, port);
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            String fromServer;
            String fromUser;
            Scanner scanner = new Scanner(System.in);

            while((fromServer = input.readLine()) != null){
                System.out.println("Server: "+ fromServer);
                fromUser = scanner.nextLine();

                if(fromUser != null){
                    output.println(fromUser);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws UnknownHostException {
        new TelefonClient();
    }
}
