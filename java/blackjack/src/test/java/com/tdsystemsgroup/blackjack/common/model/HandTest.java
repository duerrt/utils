package com.tdsystemsgroup.blackjack.common.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by duerrt on 1/14/17.
 */
public class HandTest {
    Card sevenOfClubs = new Card(Card.Suits.clubs.toString(), Card.cardValues.get(Card.cardLabels.get(7)), Card.cardLabels.get(7) );
    Card aceOfSpades = new Card(Card.Suits.spades.toString(), Card.cardValues.get(Card.cardLabels.get(1)), Card.cardLabels.get(1) );
    Card aceOfHearts = new Card(Card.Suits.hearts.toString(), Card.cardValues.get(Card.cardLabels.get(1)), Card.cardLabels.get(1) );
    Card nineOfDiamonds = new Card(Card.Suits.diamonds.toString(), Card.cardValues.get(Card.cardLabels.get(9)), Card.cardLabels.get(9) );
    Card jackOfSpades = new Card(Card.Suits.spades.toString(), Card.cardValues.get(Card.cardLabels.get(11)), Card.cardLabels.get(11) );


    @Test
    public void getCards() throws Exception {

    }

    @Test
    public void addCard() throws Exception {

    }

    @Test
    public void scoreNoAcesTest() throws Exception {
        Hand h = new Hand();
        h.addCard(sevenOfClubs);
        h.addCard(nineOfDiamonds);
        assertEquals("Incorrect score", 16, h.getScore());
        assertEquals("Incorrect alternateScore", 0, h.getAlternateScore());
    }

    @Test
    public void scoreOneAceTest() throws Exception {
        Hand h = new Hand();
//        Card aceOfSpades = new Card(Card.Suits.spades.toString(), Card.cardValues.get(Card.cardLabels.get(1)), Card.cardLabels.get(1) );
//        Card aceOfHearts = new Card(Card.Suits.hearts.toString(), Card.cardValues.get(Card.cardLabels.get(1)), Card.cardLabels.get(1) );
        h.addCard(sevenOfClubs);
        h.addCard(aceOfSpades);
        assertEquals("Incorrect score", 18, h.getScore());
        assertEquals("Incorrect alternateScore", 8, h.getAlternateScore());
    }
    @Test
    public void scoreTwoAcesTest() throws Exception {
        Hand h = new Hand();
        h.addCard(sevenOfClubs);
        h.addCard(aceOfSpades);
        h.addCard(aceOfHearts);
        assertEquals("Incorrect score", 19, h.getScore());
        assertEquals("Incorrect alternateScore", 9, h.getAlternateScore());
    }


}