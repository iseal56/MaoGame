package me.iseal.commands;

import me.iseal.backend.CardManager;
import me.iseal.player.Player;

import java.util.Random;

import static me.iseal.Main.gm;

public class StartGame {
    CardManager cardManager = new CardManager();

    public void execute(){
        Player plr1 = new Player();
        Player plr2 = new Player();
        for (int i = 0; i < 3; i++) {
            plr1.addCard(cardManager.generateRandomCard());
            plr2.addCard(cardManager.generateRandomCard());
        }
        gm.setRandomCurrentPlayer();
    }
}
