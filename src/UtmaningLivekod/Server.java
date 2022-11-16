package UtmaningLivekod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port = 1338;
    public Server(){
        try(ServerSocket servS = new ServerSocket(port)){
            Socket socket = servS.accept();
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String temp = "Amendurå";

            while(true){
                output.println(temp);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
