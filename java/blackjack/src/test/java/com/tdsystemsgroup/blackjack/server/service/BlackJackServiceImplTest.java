package com.tdsystemsgroup.blackjack.server.service;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.GameResponse;
import com.tdsystemsgroup.blackjack.common.model.Hand;
import com.tdsystemsgroup.blackjack.common.model.Player;
import com.tdsystemsgroup.blackjack.server.model.Game;
import org.junit.Test;

import java.util.List;

/**
 * Created by duerrt on 1/14/17.
 */
public class BlackJackServiceImplTest {
    @Test
    public void gameStatusTest() throws Exception {
        BlackJackServiceImpl bj = new BlackJackServiceImpl();
        Integer gameId = bj.create(1);
        Game g = bj.games.get(gameId);
        List<Player> players = g.getPlayers();
        Player p = players.get(0);
        Hand h = new Hand();
        p.setHand(h);
        Card sevenOfClubs = new Card(Card.Suits.clubs.toString(), Card.cardValues.get(Card.cardLabels.get(7)), Card.cardLabels.get(7) );
        Card aceOfSpades = new Card(Card.Suits.spades.toString(), Card.cardValues.get(Card.cardLabels.get(1)), Card.cardLabels.get(1) );

        p.getHand().addCard(sevenOfClubs);
        p.getHand().addCard(aceOfSpades);
        GameResponse gr = bj.gameStatus(gameId);
        System.out.println(" gr "+ gr.getStatus());



    }

    @Test
    public void deal() throws Exception {

    }

}