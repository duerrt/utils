package com.tdsystemsgroup.blackjack.server.model;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.Player;

import java.util.ArrayList;

/**
 * Created by duerrt on 5/30/16.
 */
public class Game {

    private ArrayList<Player> players;

    private Deck deck = null;

    private Integer id = null;

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

    public Player getDealer() {
        for (Player player : players) {
            if (player.isDealer()){
                return player;
            }
        }
        return null;
    }
}
