package com.tom.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 8/18/15.
 */
public class Player {

    public Player(boolean isDealer, String name){
        this.dealer = isDealer;
        this.name = name;
    }
    List<Card> cards = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean dealer = false;

    String name = null;

    public boolean isDealer() {
        return dealer;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getScore(){
        int score = 0;
        for (Card c : cards){
            score += c.getValue();
        }
        return score;
    }

    public int getDealerShowScore(){
        int score = 0;
        for (Card c : cards){
            score += c.getValue();
        }
        // subtract hold card
        return (score - cards.get(0).getValue());
    }

    public void addCard(Card c) throws Exception{
        int score = getScore();
        if ((score + c.getValue()) > 21){
            System.out.println("Busted:" +  score +  "new card" + c.getValue() );

            throw new Exception("Busted with " +  c.getValue());
        }
     //   System.out.println("dealt card is " +  c.getValue());
        cards.add(c);
    }


}
