package com.tdsystemsgroup.blackjack.server.service;

import com.tdsystemsgroup.blackjack.common.model.DealResponse;
import com.tdsystemsgroup.blackjack.common.model.GameResponse;
import com.tdsystemsgroup.blackjack.server.model.Game;

/**
 * Created by duerrt on 5/30/16.
 */
public interface GameService {

    public Integer create(int numberOfPlayers);

 //   public void start(Integer gameId);

  //  public void play(Integer gameId);
    public DealResponse deal(Integer gameId, Integer playerId);

    public GameResponse gameStatus(Integer gameId);
    public void finish(Integer gameId);

}
