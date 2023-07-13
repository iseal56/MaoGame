package me.iseal.backend;

import me.iseal.exception.PlayerNotExistantException;
import me.iseal.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class GameManager {

    private Player currentPlayer;
    private final Random rand = new Random();
    private ArrayList<Player> plrList = new ArrayList<>();
    private final Logger l = LogManager.getRootLogger();

    public GameManager(){
        createPool();
    }

    private void createPool(){
        plrList.add(new Player());
        plrList.add(new Player());
        plrList.add(new Player());
        plrList.add(new Player());
    }

    public void updatePlayerAt(int index, Player p){
        plrList.remove(index);
        plrList.add(index, p);
    }
    public Player getPlayerAt(int index){
        return plrList.get(index);
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public void setRandomCurrentPlayer() {
        currentPlayer = plrList.get(rand.nextInt(plrList.size()));
    }

}
