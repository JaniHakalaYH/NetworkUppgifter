package UtmaningLivekod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    int port = 1338;

    public Client() throws IOException {

        String messageToPrint = "";

        InetAddress address = InetAddress.getByName("127.0.0.1");
        try(Socket socket = new Socket(address, port);
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            while((messageToPrint = input.readLine()) != null) {
                System.out.println(messageToPrint);
                Thread.sleep(1000);
            }
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
    }
}