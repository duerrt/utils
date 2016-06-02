package com.tom.blackjack.service;

import com.tom.blackjack.model.Game;

/**
 * Created by duerrt on 5/30/16.
 */
public interface BlackJackService {

    public Game create(int numberOfPlayers);

    public void start(Integer gameId);

    public void play(Integer gameId);

    public void finish(Integer gameId);

}
