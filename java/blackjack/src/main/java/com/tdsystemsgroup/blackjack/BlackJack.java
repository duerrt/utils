package com.tdsystemsgroup.blackjack;

import com.tdsystemsgroup.blackjack.model.Card;
import com.tdsystemsgroup.blackjack.model.Game;
import com.tdsystemsgroup.blackjack.model.Player;

import com.tdsystemsgroup.blackjack.service.GameService;
import com.tdsystemsgroup.blackjack.service.BlackJackServiceImpl;

import java.util.Scanner;

/**
 * Created by duerrt on 8/17/15.
 */
public class BlackJack {


    public static void main(String[] args) {


        GameService bJack = new BlackJackServiceImpl();

        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        System.out.println("Start a new game! ");
        System.out.print("How many players: ");

        // get their input as a String
        int numbPlayers = scanner.nextInt();

        Game game = bJack.create(numbPlayers);
        bJack.start(game.getId());
        bJack.play(game.getId());
        bJack.finish(game.getId());


    }

    private void dumpPlayer(Player p){
       for (Card c : p.getCards()){
           System.out.println(p.getName() + " - Card: " + c.getLabel() + " " + c.getValue());
       }

    }
}

