package me.iseal.networking.client;

public enum ClientMessage {
    LIST_CARDS("LIST"),
    START_GAME("START_GAME");

    public String messageToSend;
    ClientMessage(String toSend){
        messageToSend = toSend;
    }
}
