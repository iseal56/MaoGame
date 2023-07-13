package me.iseal;

import me.iseal.commands.ListCards;
import me.iseal.commands.StartGame;
import me.iseal.exception.PlayerNotExistantException;
import me.iseal.networking.NetworkingManager;
import me.iseal.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CommandManager {
    private final Logger l = LogManager.getRootLogger();
    private final StartGame sg = new StartGame();
    private final ListCards lc = new ListCards();
    private final NetworkingManager nm = new NetworkingManager();
    private boolean connectedToServer = false;
    private boolean establishedConnection = false;

    public void handleCommands() {
        Scanner input = new Scanner(System.in);
        System.out.println("Armed and ready.");
            while (input.hasNext()) {
                String cmd = input.next();
                if (!establishedConnection) {
                    if (cmd.contains("startserver")) {
                        nm.startServer(80);
                        establishedConnection = true;
                        connectedToServer = false;
                    } else if (cmd.contains("connectto")) {
                        nm.startClient("localhost", 80);
                        establishedConnection = true;
                        connectedToServer = true;
                    }
                } else {
                    switch (cmd.toLowerCase()) {
                        case "start":
                            sg.execute();
                            break;
                        case "list":
                            lc.execute();
                            break;
                        case "exit":
                            System.exit(1);
                            break;
                        default:
                            System.out.println("Comando non riconosciuto");
                            break;
                    }
                }
            }
    }
}
