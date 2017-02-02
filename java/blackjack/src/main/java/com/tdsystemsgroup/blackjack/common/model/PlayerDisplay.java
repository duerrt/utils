package com.tdsystemsgroup.blackjack.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 6/12/16.
 */
public class PlayerDisplay {

    private Integer playerId;

    private String name = null;

    private String status = "";

    private String score;

    private String alternateScore;

    private String cardDisplay;

    public PlayerDisplay() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getScore() {
        return score;
    }

    public String getCardDisplay() {
        return cardDisplay;
    }

    public void setCardDisplay(String cardDisplay) {
        this.cardDisplay = cardDisplay;
    }


    public void setScore(String score) {
        this.score = score;
    }

    public String getAlternateScore() {
        return alternateScore;
    }

    public void setAlternateScore(String alternateScore) {
        this.alternateScore = alternateScore;
    }

    @Override
    public String toString() {
        return "PlayerDisplay{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", score='" + score + '\'' +
                ", alternateScore='" + alternateScore + '\'' +
                ", cardDisplay='" + cardDisplay + '\'' +
                '}';
    }
}
