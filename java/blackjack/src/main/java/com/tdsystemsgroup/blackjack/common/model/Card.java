package com.tdsystemsgroup.blackjack.common.model;

import java.util.*;

/**
 * Created by duerrt on 8/17/15.
 */
public class Card {

    String suit = null;

    int value;

    String label;

    public static Map<Integer, String> cardLabels  = initCardLabels();

    public static Map<String, Integer> cardValues  = initCardValues();

    public enum Suits {
     clubs, diamonds, hearts, spades
    }

    public Card(String suit, int index, String  label){
      this.suit = suit;
        this.value = index;
        this.label = label;

    }


    @Override
    public String toString() {

        return (this.label + " of " + this.suit);
    }

    protected static Map<Integer, String> initCardLabels() {
        final Map<Integer, String> cardMap = new HashMap<>();
        cardMap.put(1, "Ace");
        cardMap.put(2, "two");
        cardMap.put(3, "three");
        cardMap.put(4, "four");
        cardMap.put(5, "five");
        cardMap.put(6, "six");
        cardMap.put(7, "seven");
        cardMap.put(8, "eight");
        cardMap.put(9, "nine");
        cardMap.put(10, "ten");
        cardMap.put(11, "Jack");
        cardMap.put(12, "Queen");
        cardMap.put(13, "King");
    
        return Collections.unmodifiableMap(cardMap);
    }

    protected static Map<String, Integer> initCardValues() {
        final Map<String, Integer> cardMap = new HashMap<>();
        cardMap.put("Ace" ,11);
        cardMap.put("two", 2);
        cardMap.put("three", 3);
        cardMap.put("four", 4);
        cardMap.put("five", 5);
        cardMap.put("six", 6);
        cardMap.put("seven", 7);
        cardMap.put("eight", 8);
        cardMap.put("nine", 9);
        cardMap.put("ten", 10);
        cardMap.put("Jack", 10);
        cardMap.put("Queen", 10);
        cardMap.put("King", 10);

        return Collections.unmodifiableMap(cardMap);
    }

    public int getValue()
    {
        return value;
    }

    public String getLabel()
    {
        return label;
    }

}


