package me.iseal;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class Utils {

    Logger l = LogManager.getRootLogger();
    InetAddressValidator addressValidator = InetAddressValidator.getInstance();

    public boolean isNumber(String s){
        try {
            Integer.valueOf(s);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void handleException(Exception e){
        l.error(e.getMessage());
        for (StackTraceElement el : e.getStackTrace()){
            l.error(el);
        }
        System.out.println("The program encountered an error and needs to exit. Check logs for more information.");
        System.exit(-1);
    }

    public boolean checkIfValidIP(String addr){
        if (addr.equalsIgnoreCase("localhost")){
            return true;
        }
        return addressValidator.isValid(addr);
    }

}
