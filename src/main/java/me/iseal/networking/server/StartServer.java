package me.iseal.networking.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer extends Thread {

    ServerSocket ss;
    Logger l = LogManager.getRootLogger();

    public void run(){
        receiveMessages();
    }

    public StartServer(int port){
        try {
            ss = new ServerSocket(80);
        } catch (Exception e){
            l.error(e.getMessage());
            for (StackTraceElement el : e.getStackTrace()){
                l.error(el);
            }
            System.out.println("The program encountered an error and needs to exit. Check logs for more information.");
            System.exit(-1);
        }
    }

    private void receiveMessages(){
        try {
            System.out.println("Started server");
            Socket socket = ss.accept();
            RequestHandler requestHandler = new RequestHandler(socket);
            requestHandler.start();
        } catch (Exception e){
            l.error(e.getMessage());
            for (StackTraceElement el : e.getStackTrace()){
                l.error(el);
            }
            System.out.println("The program encountered an error and needs to exit. Check logs for more information.");
            System.exit(-1);
        }
    }

}
