package Uppgift12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

            while(true){

            }
        }catch(IOException e){
            System.out.println("whoops: "+ e.getMessage());
        } finally{
            try {
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
