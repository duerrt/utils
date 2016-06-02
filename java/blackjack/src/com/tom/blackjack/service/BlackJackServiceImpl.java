package com.tom.blackjack.service;

import com.tom.blackjack.model.Deck;
import com.tom.blackjack.model.Game;
import com.tom.blackjack.model.Player;

import java.util.*;

/**
 * Created by duerrt on 5/30/16.
 */
public class BlackJackServiceImpl implements BlackJackService{

    private static int baseId = 1000;

    Map<Integer,Game>games = null;

    public void BlackJackServiceImpl(){
        games = new HashMap<>();

    }

    @Override
    public Game create(int numberOfPlayers) {
        Game game =  new Game();
        game.setId(getNextId());
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(true, "Dealer"));

        Player dealer =  players.get(0);
        for (int i=0; i<numberOfPlayers; i++){
            players.add(new Player(false, "Player"+i));
        }

        game.setPlayers(players);

        games.put(game.getId(), game);

        return game;
    }

    @Override
    public void finish(Integer gameId) {

    }

    @Override
    public void play(Integer gameId) {
    }

    @Override
    public void start(Integer gameId) {
        Player dealer = games.get(gameId).getDealer();
        Deck deck = games.get(gameId).getDeck();
        try {
            dealer.addCard(deck.deal());
            dealer.addCard(deck.deal());
        } catch (Exception e) {
            System.out.println("wont happen");
        }

        for (Player player : games.get(gameId).getPlayers()) {
            try {
                player.addCard(deck.deal());
                player.addCard(deck.deal());
            } catch (Exception e) {
                System.out.println("wont happen");
            }
        }

    }

    private synchronized  Integer getNextId(){
        baseId += 1;
        return baseId;
    }
}
