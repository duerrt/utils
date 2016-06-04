package com.tdsystemsgroup.blackjack.server.service;

import com.tdsystemsgroup.blackjack.server.model.Game;

/**
 * Created by duerrt on 5/30/16.
 */
public interface GameService {

    public Integer create(int numberOfPlayers);

 //   public void start(Integer gameId);

  //  public void play(Integer gameId);

    public void finish(Integer gameId);

}
