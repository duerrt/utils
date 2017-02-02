package com.tdsystemsgroup.blackjack.server.model;

import com.tdsystemsgroup.blackjack.common.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Deck class to simulate a deck of cards
 *
 * Created by duerrt on 8/17/15.
 */
public class Deck {

    List<Card> cards = new ArrayList();

    public Deck (){
        for (Card.Suits suit : Card.Suits.values()) {
            for (int i=1; i<14; i++){
                Card c = null;
                c = new Card(suit.toString(),
                        Card.cardValues.get(Card.cardLabels.get(i)), Card.cardLabels.get(i) );
                cards.add(c);
            }
        }
        shuffle();
    }

    public  void dumpCards(){
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    public Card deal(){
        return cards.remove(0);
    }

    private void shuffle(){
        for ( int i=0; i<cards.size() ; i++) {
            Card tmp = cards.get(i);
            int j = ( int ) ( Math.random( ) * 52 );
            cards.set(i, cards.get(j));
            cards.set(j, tmp);
       }
    }
}
