package me.iseal.backend;

import com.google.common.collect.Maps;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;

public enum Symbol {

    KING("Rè", "K"),
    QUEEN("Regina","Q"),
    JACK("Jack", "J"),
    ACE("Asso", "A");

    String read = "";
    String smallRead = "";

    private static final Map<String, Symbol> LOOKUP = Maps.uniqueIndex(
            Arrays.asList(Symbol.values()),
            Symbol::getSmallRead
    );

    Symbol(String readable, String smallReadable){
        read = readable;
        smallRead = smallReadable;
    }

    public String getSmallRead(){
        return smallRead;
    }
    @Nullable
    public static Symbol fromSmallRead(String smallReadable) {
        return LOOKUP.get(smallReadable);
    }
}
