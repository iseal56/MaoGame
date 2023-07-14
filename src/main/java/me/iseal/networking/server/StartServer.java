package me.iseal.networking.server;

import me.iseal.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer extends Thread {

    ServerSocket ss;
    Utils utils = new Utils();
    Logger l = LogManager.getRootLogger();

    public void run(){
        receiveMessages();
    }

    public StartServer(int port){
        try {
            ss = new ServerSocket(80);
        } catch (Exception e){
            utils.handleException(e);
        }
    }

    private void receiveMessages(){
        try {
            System.out.println("Started server");
            while (true) {
                Socket socket = ss.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (Exception e){
            utils.handleException(e);
        }
    }

}
