package me.iseal.networking.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class StartClient extends Thread {

    private final Logger l = LogManager.getRootLogger();
    private Socket socket;
    private final ProcessMessages pm = new ProcessMessages();
    private String ip;
    private int port;

    public StartClient(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        openTunnel(ip, port);
    }

    public void openTunnel(String ip, int port){
        try {
            socket = new Socket(ip, port);
            receiveMessages();
        } catch (Exception e){
            l.error(e.getMessage());
            for (StackTraceElement el : e.getStackTrace()){
                l.error(el);
            }
            System.out.println("The program encountered an error and needs to exit. Check logs for more information.");
            System.exit(-1);
        }
    }

    private void receiveMessages() throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        while (true) {
            String currentLine = in.readLine();
            if (currentLine != null){
                pm.process(currentLine);
                l.info("Received message "+currentLine);
                System.out.println("Debug: "+currentLine);
            }
            Thread.sleep(10);
        }
    }



}
