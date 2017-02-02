package com.tdsystemsgroup.blackjack.server;

import com.tdsystemsgroup.blackjack.common.model.DealResponse;
import com.tdsystemsgroup.blackjack.common.model.GameResponse;
import com.tdsystemsgroup.blackjack.common.model.PlayerDisplay;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static com.tdsystemsgroup.blackjack.server.service.BlackJackServiceImpl.getInstance;

/**
 * Created by duerrt on 1/18/17.
 */
@Path("/create")
public class BlackJackResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer create(Integer numberOfPlayers){
        System.out.println("xxxxxxxxxxxxxxxxxx" + numberOfPlayers);
        Integer gameId = getInstance().create(numberOfPlayers) ;
        return gameId;
    }

    @GET
    @Produces("text/plain")
    public String mine2(){
        return "123abc";
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

    public GameResponse finish(Integer gameId){
        return getInstance().finish(gameId) ;
    }


}
