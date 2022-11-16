package LivekodningTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    int port = 1337;
    String message = "Amendurå";
    public Client() throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        try(Socket socket = new Socket(address, port);
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            String fromServer;

            while(true) {
                output.println(message);
                fromServer = input.readLine();
                Thread.sleep(3000);
                System.out.println(fromServer);
            }
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        Client c = new Client();
    }
}
