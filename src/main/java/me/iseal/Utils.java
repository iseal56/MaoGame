package me.iseal;

public class Utils {

    public boolean isNumber(String s){
        try {
            Integer.valueOf(s);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
