package me.iseal.networking.client;

import me.iseal.backend.Card;
import me.iseal.backend.CardManager;
import me.iseal.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import static me.iseal.Main.gm;

public class ProcessMessages {

    CardManager cm = new CardManager();
    Logger l = LogManager.getRootLogger();

    public void process(String in) {
        if (in.contains("CARDS: ")) {
            int playerArrayNumber = Integer.parseInt(String.valueOf(in.charAt(0)));
            String cards = in.replace(playerArrayNumber+"CARDS: ", "");
            Player p = gm.getPlayerAt(playerArrayNumber);
            for (String card : cards.split(" ")){
                p.addCard(cm.interpretCard(card.replace(" ", "")));
            }
            gm.updatePlayerAt(playerArrayNumber, p);
            l.info("Got new cards! "+p.getAllReadable());
        } else {
            System.out.println("New message: "+in);
        }
    }
}
