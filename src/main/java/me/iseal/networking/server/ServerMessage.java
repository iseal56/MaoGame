package me.iseal.networking.server;

public enum ServerMessage {
    START_GAME("START_GAME"),
    CARD_LIST("CARDS: ");

    public String messageToSend;

    ServerMessage(String msg){
        messageToSend = msg;
    }
}
