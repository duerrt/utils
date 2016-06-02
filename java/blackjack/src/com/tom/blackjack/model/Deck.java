package com.tom.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 8/17/15.
 */
public class Deck {

    List<Card> cards = new ArrayList();

    public Deck shuffle(){
     init();
     return this;
    }

    private void init(){

        for (Card.Suits suit : Card.Suits.values()) {
            for (int i=1; i<14; i++){
                Card c = null;
                    c = new Card(suit.toString(), Card.cardValues.get(Card.cardLabels.get(i)), Card.cardLabels.get(i) );
                    cards.add(c);
            }
        }
    }



    public  List<Card> getCards(){
        return cards;
    }
    public  void dumpCards(){
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    public Card deal(){
        int index = (int)(Math.random()*cards.size() );
        Card c = cards.get(index);
        cards.remove(index);
        return c;
    }

    public void shuffle(int cnt){
        for ( int i=0; i<cnt ; i++) {
            int n = (int)(Math.random()*cards.size() );
            int k = (int)(Math.random()*cards.size() );
            Card tmp = cards.get(n);

            cards.set(n,cards.get(k));
            cards.set(k, tmp);
       }

    }

}
