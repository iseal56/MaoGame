package me.iseal.networking.server;

import me.iseal.player.Player;

import java.net.Socket;

public class NetworkPlayer {

    public Socket socket;
    public Player player;

    public NetworkPlayer(Socket sk, Player p){
        socket = sk;
        player = p;
    }
}
