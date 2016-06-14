package com.tdsystemsgroup.blackjack.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 8/18/15.
 */
public class Player {

    private static int basePlayerId = 1000;

    private Integer playerId;

    private List<Card> cards = new ArrayList();

    private String name = null;

    private String status = "";

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.playerId = getNextId();
    }

    public String getName()
    {
        return name;
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

    public int getMinScore() {
        int score = 0;
        for (Card c : cards) {
            score += c.getMinValue();
        }
        return score;
    }

    public void addCard(Card c) throws Exception {
        cards.add(c);

        if (getScore() > 21 && getMinScore() > 21){
            throw new Exception("Busted with " + c.getValue());
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for (Card c: cards){
            cardString.append(c);
            cardString.append(" ");
        }

        String score = (getScore() == getMinScore()) ? ""+getScore() : ""+getScore()+"/"+getMinScore();
        return "Player{" +
                "cards=" + cardString.toString() +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    private synchronized Integer getNextId() {
        basePlayerId += 1;
        return basePlayerId;
    }


}
