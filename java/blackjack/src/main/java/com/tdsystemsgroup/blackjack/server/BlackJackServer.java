package com.tdsystemsgroup.blackjack.server;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.Player;
import java.util.ArrayList;

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

    public Card deal(Integer gameId){
        return getInstance().deal(gameId) ;
    }

    public ArrayList<Player> getPlayers(Integer gameId){
        return getInstance().getPlayers(gameId);
    }
    public void finish(Integer gameId){
        getInstance().finish(gameId) ;
    }

}
