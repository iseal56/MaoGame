package me.iseal.backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Card {
    Color col = null;
    int num = -1;
    Symbol smb = null;
    boolean isNum = false;
    Logger l = LogManager.getRootLogger();

    public Card (Color color, int number){
        col = color;
        num = number;
        isNum = true;
        l.info("Created new card with attributes "+ col.read + " "+ number+ " is Num? "+isNum);
    }
    public Card (Color color, Symbol number){
        col = color;
        smb = number;
        isNum = false;
        l.info("Created new card with attributes "+ col.read + " "+ number.read+ " is Num? "+isNum);
    }

    public String getReadable(){
        if (isNum){
            return num+" di "+col.read;
        } else {
            return smb.read+" di "+ col.read;
        }
    }
}
