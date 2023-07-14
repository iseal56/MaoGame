package me.iseal;

import me.iseal.commands.client.ForceListCards;
import me.iseal.commands.client.ListCards;
import me.iseal.commands.server.StartGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static me.iseal.Main.nm;

public class CommandManager {
    private final Logger l = LogManager.getRootLogger();
    private final Utils utils = new Utils();
    private final StartGame sg = new StartGame();
    private final ListCards lc = new ListCards();
    private final ForceListCards flc = new ForceListCards();
    private boolean connectedToServer = false;
    private boolean establishedConnection = false;

    public void handleCommands() {
        Scanner input = new Scanner(System.in);
        System.out.println("Armed and ready.");
            while (input.hasNext()) {
                String cmd = input.next();
                l.info("Command received: "+cmd);
                if (!establishedConnection) {
                    if (cmd.contains("startserver")) {
                        nm.startServer(80);
                        establishedConnection = true;
                        connectedToServer = false;
                        System.out.println("Server hosted on port 80");
                    } else if (cmd.contains("connectto")) {
                        String ipToConnect = cmd.replace("connectto", "").replace("_","");
                        System.out.println("cmd = |" + cmd+"|");
                        System.out.println("iptoconnect = |" + ipToConnect+"|");
                        if (ipToConnect.equals("") || !(utils.checkIfValidIP(ipToConnect))){
                            System.out.println("You have to include a valid IP to do that.");
                        } else {
                            nm.startClient(ipToConnect, 80);
                            establishedConnection = true;
                            connectedToServer = true;
                        }
                    }
                } else {
                    switch (cmd.toLowerCase()) {
                        case "start":
                            sg.execute();
                            break;
                        case "list":
                            lc.execute();
                            break;
                        case "forcelist":
                            flc.execute();
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
