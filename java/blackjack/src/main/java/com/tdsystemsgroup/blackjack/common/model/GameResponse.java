package com.tdsystemsgroup.blackjack.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duerrt on 6/12/16.
 */
public class GameResponse extends ServerResponse{

    public GameResponse() {
        super();
    }

    private DealerDisplay dealerStatus;

    private List<PlayerDisplay> playerStatus = new ArrayList<>();

    public List<PlayerDisplay> getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(List<PlayerDisplay> playerStatus) {
        this.playerStatus = playerStatus;
    }

    public DealerDisplay getDealerStatus() {
        return dealerStatus;
    }

    public void setDealerStatus(DealerDisplay dealerStatus) {
        this.dealerStatus = dealerStatus;
    }
}
