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

    public Game() {

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

}
