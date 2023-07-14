package me.iseal.backend;

import me.iseal.networking.server.NetworkPlayer;
import me.iseal.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {

    private Player clientPlayer;
    private final Random rand = new Random();
    private ArrayList<NetworkPlayer> plrList = new ArrayList<>();
    private final Logger l = LogManager.getRootLogger();


    public void updateClientPlayer(Player cp){
        clientPlayer = cp;
    }
    public Player getClientPlayer(){
        return clientPlayer;
    }

    public void addNetworkPlayer(NetworkPlayer np){
        plrList.add(np);
    }

}
