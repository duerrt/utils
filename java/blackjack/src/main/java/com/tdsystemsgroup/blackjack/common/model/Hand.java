package com.tdsystemsgroup.blackjack.common.model;

import com.tdsystemsgroup.blackjack.server.service.BlackJackScorer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duerrt on 1/10/17.
 */

public class Hand {

    String status;
    int score = 0;
    int alternateScore = 0;

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.getCards().add(card);
        BlackJackScorer.score(this);
    }

    @Override
    public String toString() {
        String alternateScoreDisplay = "";
        if (alternateScore > 0){
            alternateScoreDisplay = ", alernateScore=" + alternateScore;
        }
        return "Hand{" +
                "status='" + status + '\'' +
                ", score=" + score +
                alternateScoreDisplay +
                ", cards=" + cards +
                '}';
    }

    private List<Card> cards = new ArrayList();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getScore() {
        return this.score;

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAlternateScore() {
        return this.alternateScore;
    }

    public void setAlternateScore(int alternateScore) {
        this.alternateScore = alternateScore;
    }

    }
