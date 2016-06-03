package com.tom.blackjack;

import com.tom.blackjack.model.Card;
import com.tom.blackjack.model.Deck;
import com.tom.blackjack.model.Player;
import com.tom.blackjack.model.Game;

import com.tom.blackjack.service.GameService;
import com.tom.blackjack.service.BlackJackServiceImpl;

import java.util.ArrayList;
import java.util.List;
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

