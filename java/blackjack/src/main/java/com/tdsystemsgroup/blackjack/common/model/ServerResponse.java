package com.tdsystemsgroup.blackjack.common.model;

/**
 * Created by duerrt on 6/11/16.
 */
public class ServerResponse {

    public static final String BUSTED = "Busted";
    public static final String WINNER = "Winner";
    public static final String PUSH = "Push";
    public static final String ACTIVE = "Active";

    private String displayMessage;

    private String status;


    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
