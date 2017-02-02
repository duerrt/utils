package com.tdsystemsgroup.blackjack.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 8/18/15.
 */
public class Player {

    private static int basePlayerId = 1000;

    private Integer playerId;

    private Hand hand = new Hand();

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    private String name = null;

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
        return hand.getCards();
    }

    public Hand getHand() {
        return hand;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        this.getCards().forEach(card ->{
            cardString.append(card);
            cardString.append(" ");
        });

       String score = (hand.getStatus());
//        String score = (hand.getScore() == hand.getMinScore()) ? ""+hand.getScore() : ""+hand.getScore()+"/"+hand.getMinScore();
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
