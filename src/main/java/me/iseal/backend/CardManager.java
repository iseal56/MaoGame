package me.iseal.backend;

import me.iseal.Utils;
import org.checkerframework.checker.units.qual.C;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class CardManager {
    Color suits[] = {Color.CUORI, Color.QUADRI, Color.FIORI, Color.PICCHE};
    Random rand = new Random();
    Utils utils = new Utils();

    public Card generateRandomCard(){
        Card card;
        switch (rand.nextInt(13)+1){
            case 1:
                card = new Card(suits[rand.nextInt(suits.length)], Symbol.ACE);
                break;
            case 11:
                card = new Card(suits[rand.nextInt(suits.length)], Symbol.JACK);
                break;
            case 12:
                card = new Card(suits[rand.nextInt(suits.length)], Symbol.QUEEN);
                break;
            case 13:
                card = new Card(suits[rand.nextInt(suits.length)], Symbol.KING);
                break;
            default:
                card = new Card(suits[rand.nextInt(suits.length)], rand.nextInt(2,11));
                break;
        }
        return card;
    }

    public Card interpretCard(String s){
        Card card;
        String symbol = String.valueOf(s.charAt(0));
        Color color = Color.fromSmallRead(String.valueOf(s.charAt(1)));
        if (utils.isNumber(symbol)) {
            card = new Card(color, Integer.parseInt(symbol));
        } else {
            card = new Card(color, Symbol.fromSmallRead(symbol));
        }
        return card;
    }

}
