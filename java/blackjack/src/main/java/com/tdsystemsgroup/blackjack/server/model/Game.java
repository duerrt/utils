package com.tdsystemsgroup.blackjack.server.model;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.Dealer;
import com.tdsystemsgroup.blackjack.common.model.Player;

import java.util.ArrayList;

/**
 * Created by duerrt on 5/30/16.
 */
public class Game {

    private ArrayList<Player> players;

    private Deck deck = null;

    private Integer id = null;

    private Dealer dealer = null;

    private String status = null;

    public Game(Integer id) {
        this.id = id;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Integer getId() {
        return id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
