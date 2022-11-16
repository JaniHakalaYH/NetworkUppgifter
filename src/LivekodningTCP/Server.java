package LivekodningTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int port = 1337;
    String ack = "message recieved";
    String welcome = "Hej och välkommen";
    public Server(){
        try(ServerSocket servS = new ServerSocket(port)){
            Socket socket = servS.accept();
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String temp = "";

            output.println(welcome);
            while((temp = input.readLine()) != null){
                System.out.println(temp);
                output.println(ack+ " " +temp);
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Server s = new Server();
    }
}
