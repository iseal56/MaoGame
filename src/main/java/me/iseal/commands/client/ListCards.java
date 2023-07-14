package me.iseal.commands.client;

import me.iseal.backend.Card;

import static me.iseal.Main.gm;

public class ListCards {
    public void execute() {
        if (gm.getClientPlayer() != null) {
            System.out.print("These are your cards: ");
            System.out.print("\n");
            for (Card card : gm.getClientPlayer().getAllCards()) {
                System.out.print(card.getReadable() + " | ");
            }
        } else {
            System.out.println("You have to start the game first");
        }
    }
}
