package me.iseal;

import me.iseal.Logging.LoggerManager;
import me.iseal.backend.GameManager;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static CommandManager cm;
    public static GameManager gm;
    public static void main(String[] args) {
        LoggerManager lm = new LoggerManager();
        lm.setUpLogger();
        cm = new CommandManager();
        gm = new GameManager();
        cm.handleCommands();
    }
}