package me.iseal.player;

import me.iseal.backend.Card;

import java.lang.invoke.StringConcatException;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<>();

    public String getAllReadable(){
        StringBuilder sb = new StringBuilder();
        for (Card card : cards){
            sb.append(card.getReadable()+" ");
        }
        return sb.toString();
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }
    public ArrayList<Card> getAllCards(){
        return cards;
    }
}
