package com.tdsystemsgroup.blackjack.server.service;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.Hand;
import com.tdsystemsgroup.blackjack.common.model.ServerResponse;

/**
 * Created by duerrt on 1/10/17.
 */
public class BlackJackScorer {


    public static void score(Hand h) {
        int score = 0;
        int howManyAces = 0;
        for (Card c : h.getCards()) {
            score += c.getValue();
            if (c.isAce()) {
                howManyAces++;
            }
        }

        if (score == 21) {
            if (howManyAces ==  1){
                h.setStatus(ServerResponse.BLACKJACK);
            } else {
                h.setStatus(ServerResponse.WINNER);
            }
            h.setScore(score);
        } else if (score > 21 && howManyAces > 0) {
            h.setStatus(ServerResponse.ACTIVE);
            h.setScore(score - 10);
            h.setAlternateScore(score - (10 * howManyAces));
        } else if (score > 21 && howManyAces == 0) {
            h.setStatus(ServerResponse.BUSTED);
            h.setScore(score);
        } else if (score < 21 && howManyAces == 0) {
            h.setStatus(ServerResponse.ACTIVE);
            h.setScore(score);
        } else if (score < 21 && howManyAces > 0) {
            h.setStatus(ServerResponse.ACTIVE);
            h.setScore(score);
            h.setAlternateScore(score - (10 * howManyAces));
        }
    }
}
