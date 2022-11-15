package Uppgift5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class TelefonServer {

    TelefonbokDatabas d = new TelefonbokDatabas();
    private int port = 1337;

    public TelefonServer(){

        try(ServerSocket servS = new ServerSocket(port)){
            Socket socket = servS.accept();
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientInput;
            String serverOutput;

            output.println("Vilken kompis vill du hitta?");

            while((clientInput = input.readLine()) != null){
                serverOutput = d.checkKompis(clientInput.trim());
                if (serverOutput == null){
                    System.out.println("Hittade inte det du söker.");
                }else{
                    output.println(serverOutput);
                }
            }

            }catch(IOException e){
                e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new TelefonServer();
    }
}
