package com.tdsystemsgroup.blackjack.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 6/12/16.
 */
public class GameResponse extends ServerResponse{

    private String dealerStatus;
    private String dealerScore;
    private List<PlayerDisplay> playerStatus = new ArrayList<>();

    public GameResponse() {
        super();
    }

    public List<PlayerDisplay> getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(List<PlayerDisplay> playerStatus) {
        this.playerStatus = playerStatus;
    }

    public String getDealerStatus() {
        return dealerStatus;
    }

    public void setDealerStatus(String dealerStatus) {
        this.dealerStatus = dealerStatus;
    }

    public String getDealerScore() {
        return dealerScore;
    }

    public void setDealerScore(String dealerScore) {
        this.dealerScore = dealerScore;
    }


}
