package com.tdsystemsgroup.blackjack.common.model;

/**
 * Created by duerrt on 6/11/16.
 */
public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public int getDealerVisibleScore() {
        int score = 0;
        for (Card c : getCards() ) {
            score += c.getValue();
        }
        return (score - getCards().get(0).getValue());
    }

    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for (int i=1; i<getCards().size();i++){
            cardString.append(getCards().get(i));
            cardString.append(" ");
        }
        return "Dealer{" +
                "cards=" + cardString.toString() +
                " score=" + getDealerVisibleScore()+
                '}';
    }


}
