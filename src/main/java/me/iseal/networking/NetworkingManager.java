package me.iseal.networking;

import me.iseal.networking.client.ClientMessage;
import me.iseal.networking.client.StartClient;
import me.iseal.networking.server.StartServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;

import java.net.Socket;
import java.util.ArrayList;

public class NetworkingManager {

    private StartClient sc = null;
    private StartServer ss = null;
    private ArrayList<Socket> clientsConnected = new ArrayList<>(2);
    Logger l = LogManager.getRootLogger();

    public void startClient(String ip, int port){
        sc = new StartClient(ip, port);
        sc.start();
    }

    public void startServer(int port){
        ss = new StartServer(port);
        ss.start();
    }

    public void sendClientMessage(ClientMessage msg){
        sc.sendMessage(msg);
    }

    public void addClient(Socket s){
        clientsConnected.add(s);
    }

    public void removeClient(Socket s){
        clientsConnected.remove(s);
    }
    public void removeClient(int i){
        clientsConnected.remove(i);
    }
}
