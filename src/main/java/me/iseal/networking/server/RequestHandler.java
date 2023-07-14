package me.iseal.networking.server;

import me.iseal.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class RequestHandler extends Thread{

    private Socket s = null;
    private Logger l = LogManager.getRootLogger();
    private BufferedReader in;
    private PrintWriter out;
    Utils utils = new Utils();
    private final ProcessMessages pm = new ProcessMessages();

    public RequestHandler(Socket socket){
        s = socket;
    }

    public void run() {
        try {
            System.out.println("Received a connection");
            l.info("Received a connection");
            s.setKeepAlive(true);
            s.setSoTimeout(10000);
            l.info("Keepalive set to true");
            l.info("Getting streams...");
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());
            l.info("Streams ok!");
            System.out.println("Connection initialized");
            readMessages();
        } catch (Exception e) {
            utils.handleException(e);
        }
    }

    public void readMessages() throws IOException {
        String line = in.readLine();
        while (line != null && line.length() > 0) {
            pm.process(line,s);
            line = in.readLine();
        }
    }
}
