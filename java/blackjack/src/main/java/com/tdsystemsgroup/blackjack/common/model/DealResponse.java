package com.tdsystemsgroup.blackjack.common.model;

/**
 * Created by duerrt on 6/11/16.
 */
public class DealResponse extends ServerResponse {
    private int score;

    private String card;


    public DealResponse() {
        super();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

}
