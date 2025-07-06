package org.example.WordProcesser;

import java.util.*;

public class FlyweightFactory {
    public static Map<Character, ILetter> charCacheMap;

    public FlyweightFactory(){
        if(charCacheMap == null){
            charCacheMap = new HashMap<Character, ILetter>();
        }
    }

    public static ILetter createLetter(Character charValue){
        if(charCacheMap.containsKey(charValue)){
            return charCacheMap.get(charValue);
        } else {
            ILetter l = new Letter(charValue, "Arial", 10);
            charCacheMap.put(charValue, l);
            return l;
        }
    }
}
