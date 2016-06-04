package com.tdsystemsgroup.blackjack.service;

import com.tdsystemsgroup.blackjack.model.Game;

/**
 * Created by duerrt on 5/30/16.
 */
public interface GameService {

    public Game create(int numberOfPlayers);

    public void start(Integer gameId);

    public void play(Integer gameId);

    public void finish(Integer gameId);

}
