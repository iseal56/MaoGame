package me.iseal.networking.client;

import com.intellij.uiDesigner.core.Util;
import me.iseal.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class StartClient extends Thread {

    private final Logger l = LogManager.getRootLogger();
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private final ProcessMessages pm = new ProcessMessages();
    private String ip;
    private int port;
    Utils utils = new Utils();
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
            socket.setKeepAlive(true);
            socket.setSoTimeout(10000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            System.out.println("Connected to server.");
            receiveMessages();
        } catch (Exception e){
            utils.handleException(e);
        }
    }

    private void receiveMessages() throws IOException, InterruptedException {
        while (true) {
            String currentLine = in.readLine();
            if (currentLine != null){
                pm.process(currentLine);
                l.info("Received message "+currentLine);
            }
            Thread.sleep(10);
        }
    }

    public void sendMessage(ClientMessage msg){
        out.println(msg.messageToSend);
        out.flush();
    }

}
