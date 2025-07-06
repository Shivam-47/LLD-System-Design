package org.example;

import org.example.NativeWordProcessor.NativeCharacter;
import org.example.WordProcesser.FlyweightFactory;
import org.example.WordProcesser.ILetter;
import org.openjdk.jol.info.GraphLayout;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String largeString = generateString();
        nativeWordProcessor(largeString);
        flyweightWordProcessor(largeString);
    }

    private static String generateString(){
        // Generate a large string of 100,000 characters, repeating "this is that"
        StringBuilder sb = new StringBuilder();
        String pattern = "this is that ";
        int repeat = 100000 / pattern.length();
        for (int i = 0; i < repeat; i++) {
            sb.append(pattern);
        }
        String largeString = sb.toString();
        return largeString;
    }

    private static void nativeWordProcessor(String s){
        //print a message => "this is that"

        List<NativeCharacter> chars = new ArrayList<NativeCharacter>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            NativeCharacter c1 = new NativeCharacter('t', "Arial", 10, 0, i);
            chars.add(c1);
        }

        //as we can see that each letter has same details except the position
        //so the common details like char, size and font form the extrinsic attributes
        //the position form the intrinsic attributes

        System.out.println("Native approach:");
        System.out.println(GraphLayout.parseInstance(chars).toFootprint());
    }

    private static void flyweightWordProcessor(String s){
        List<ILetter> chars = new ArrayList<ILetter>();

        FlyweightFactory ff = new FlyweightFactory();

        for(int i=0;i<s.length();i++){
            ILetter il = FlyweightFactory.createLetter(s.charAt(i));
            chars.add(il);
        }

        System.out.println("Flyweight approach:");
        System.out.println(GraphLayout.parseInstance(chars, FlyweightFactory.charCacheMap.values()).toFootprint());
    }
}