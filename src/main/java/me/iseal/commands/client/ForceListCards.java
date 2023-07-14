package me.iseal.commands.client;

import me.iseal.networking.client.ClientMessage;

import static me.iseal.Main.nm;

public class ForceListCards {

    public void execute(){
        nm.sendClientMessage(ClientMessage.LIST_CARDS);
    }

}
