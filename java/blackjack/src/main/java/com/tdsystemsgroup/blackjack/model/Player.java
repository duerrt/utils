package com.tdsystemsgroup.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 8/18/15.
 */
public class Player {

    private List<Card> cards = new ArrayList();

    private boolean dealer = false;

    private String name = null;

    private String status = "";

    public Player(boolean isDealer, String name) {
        this.dealer = isDealer;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public boolean isDealer()
    {
        return dealer;
    }

    public List<Card> getCards()
    {
        return cards;
    }

    public int getScore() {
        int score = 0;
        for (Card c : cards) {
            score += c.getValue();
        }
        return score;
    }

    public int getDealerShowScore() {
        int score = 0;
        for (Card c : cards) {
            score += c.getValue();
        }
        return (score - cards.get(0).getValue());
    }

    public void addCard(Card c) throws Exception {
        int score = getScore();
        if ((score + c.getValue()) > 21) {
            throw new Exception("Busted with " + c.getValue());
        }
        cards.add(c);
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
