package com.tdsystemsgroup.blackjack.common.model;

/**
 * Created by duerrt on 1/15/17.
 */
public class DealerDisplay extends PlayerDisplay {
    private int visibleScore;
    private String visibleCard;

    public int getVisibleScore(){
        return visibleScore;
    }
    public String getVisibleCard(){
        return visibleCard;
    }

    public void setVisibleScore(int visibleScore) {
        this.visibleScore = visibleScore;
    }

    public void setVisibleCard(String visibleCard) {
        this.visibleCard = visibleCard;
    }

    @Override
    public String toString() {
        return "PlayerDisplay{" +
                ", name='dealer" +
                ", status='" + super.getStatus()+'\'' +
                ", score='" + super.getScore() + '\'' +
                ", alternateScore='" + super.getAlternateScore() + '\'' +
                ", cardDisplay='" + super.getCardDisplay() + '\'' +
                "visibleScore=" + visibleScore +
                ", visibleCard='" + visibleCard + '\'' +
                '}';  }
}
