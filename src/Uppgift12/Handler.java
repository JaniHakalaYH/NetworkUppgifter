package Uppgift12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler extends Thread {

    private Socket socket;
    private Multiwriter multiWriter;

    public Handler(Socket socket, Multiwriter multiWriter) {
        this.socket = socket;
        this.multiWriter = multiWriter;
    }

    public void run() {

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            multiWriter.addWriter(out);

            while (true) {
                String input = in.readLine();
                if (input == null) {
                    // multiWriter.removeWriter(out);
                    //socket.close();
                    return;
                }
                for (PrintWriter writer : multiWriter.getWriters()) {
                    writer.println(input);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    /* BufferedReader in;
    String prompt;

    public void Receiver(BufferedReader in, String prompt ){
        this.in = in;
        this.prompt = prompt;
    }

    @Override
    public void run() {
        try{
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(prompt+": " +inputLine);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }*/
    }
}
