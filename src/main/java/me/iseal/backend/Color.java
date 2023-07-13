package me.iseal.backend;

import com.google.common.collect.Maps;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;

public enum Color {
    PICCHE("Picche", "P"),
    FIORI("Fiori", "F"),
    QUADRI("Quadri", "Q"),
    CUORI("Cuori", "C");

    String read = "";
    String smallRead = "";

    private static final Map<String, Color> LOOKUP = Maps.uniqueIndex(
            Arrays.asList(Color.values()),
            Color::getSmallRead
    );

    Color(String readable, String smallReadable){
        read = readable;
        smallRead= smallReadable;
    }

    public String getSmallRead(){
        return smallRead;
    }

    @Nullable
    public static Color fromSmallRead(String smalLReadable) {
        return LOOKUP.get(smalLReadable);
    }

}
