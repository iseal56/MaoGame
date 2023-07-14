package me.iseal.commands.server;

import me.iseal.networking.client.ClientMessage;

import static me.iseal.Main.nm;

public class StartGame {

    public void execute(){
        nm.sendClientMessage(ClientMessage.START_GAME);
    }
}
