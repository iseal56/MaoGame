package me.iseal.networking.client;

import me.iseal.backend.Card;
import me.iseal.backend.CardManager;
import me.iseal.networking.server.ServerMessage;
import me.iseal.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import static me.iseal.Main.gm;

public class ProcessMessages {

    CardManager cm = new CardManager();
    Logger l = LogManager.getRootLogger();

    public void process(String in) {
        if (in.contains(ServerMessage.CARD_LIST.messageToSend)) {
            int playerArrayNumber = Integer.parseInt(String.valueOf(in.charAt(0)));
            String cards = in.replace(playerArrayNumber+ServerMessage.CARD_LIST.messageToSend, "");
            Player p = new Player();
            for (String card : cards.split(" ")){
                p.addCard(cm.interpretCard(card.replace(" ", "")));
            }

            l.info("Got new cards! "+p.getAllReadable()+" for player "+playerArrayNumber);
        } else {
            System.out.println("New message: "+in);
        }
    }
}
