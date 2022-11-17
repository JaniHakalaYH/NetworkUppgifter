package Uppgift7;

import Uppgift5.TelefonbokDatabas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TelefonServer extends Thread{

        Protokoll p = new Protokoll();

        Socket s;
        public TelefonServer(Socket s){
            this.s = s;
        }

        @Override
        public void run(){

            try(PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ){

                out.println(p.getOutput(null));
                String clientRequest = "";

                while((clientRequest = in.readLine()) != null){
                    String dbAnswer = p.getOutput(clientRequest.trim());
                    out.println(dbAnswer);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
