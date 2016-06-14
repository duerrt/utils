package com.tdsystemsgroup.blackjack.server;

import com.tdsystemsgroup.blackjack.common.model.*;

import java.util.ArrayList;
import java.util.List;

import static com.tdsystemsgroup.blackjack.server.service.BlackJackServiceImpl.*;

/**
 * a server class to be used until we can implement a real http server
 * to serve these requests
 *
 * Created by duerrt on 6/4/16.
 */
public class BlackJackServer {

    public Integer create(Integer numbPlayers){
        return getInstance().create(numbPlayers) ;
    }

    public DealResponse deal(Integer gameId, Integer playerId){
        return getInstance().deal(gameId, playerId) ;
    }

    public GameResponse gameStatus(Integer gameId){
        return getInstance().gameStatus(gameId) ;
    }

    public List<PlayerDisplay> getPlayers(Integer gameId){
        return getInstance().getPlayers(gameId);
    }

    public void finish(Integer gameId){
        getInstance().finish(gameId) ;
    }

    public Dealer getDealer(Integer gameId){
        return getInstance().getDealer(gameId);
    }

}
