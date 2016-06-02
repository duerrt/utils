package com.tom.blackjack;

import com.tom.blackjack.model.Card;
import com.tom.blackjack.model.Deck;
import com.tom.blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by duerrt on 5/29/16.
 */
public class Game {

    public ArrayList<Player>  players;
    Deck deck = null;

    public void play(int numberOfPlayers){

        deck = new Deck();
        deck.shuffle(50);

        players = new ArrayList<>();
        players.add(new Player(true, "Dealer"));

        Player dealer =  players.get(0);
        for (int i=0; i<numberOfPlayers; i++){
            players.add(new Player(false, "Player"+i));
        }

        List<Player> winners = initialDeal(deck, dealer, players);


        while (true) {


            for (Player player : players) {

                displayScores(dealer, player);
                // create a scanner so we can read the command-line input
                Scanner scanner = new Scanner(System.in);
                //  prompt for the user's name
                System.out.print("Enter H to hit, S to stay: ");

                // get their input as a String
                String cmd = scanner.next();

                switch (cmd) {
                    case "S":
                        break;
                    case "H":
                        try {
                            player.addCard(deck.deal());
                        } catch (Exception e) {
                            System.out.println("Sorry you busted");
                        }
                        break;

                }

            }
            if (dealer.getScore() <= 16) {
                try {
                    dealer.addCard(deck.deal());
                    //  dumpPlayer(dealer);
                } catch (Exception e) {
                    System.out.println("Dealer busted. You WON!!");
                    //dumpPlayer(dealer);
                    return;
                }
            }
        }
    }
    private List<Player> initialDeal(Deck deck, Player dealer, List<Player> players) {

        List<Player> winners = new ArrayList<>();

        try {
            dealer.addCard(deck.deal());
            dealer.addCard(deck.deal());
        } catch (Exception e) {
            System.out.println("wont happen");
        }

        for (Player player : players) {
            try {
                player.addCard(deck.deal());
                player.addCard(deck.deal());
            } catch (Exception e) {
                System.out.println("wont happen");
            }
        }

        if (dealer.getScore() == 21 ){
            winners.add(dealer);
        }
        for (Player player : players) {
            if (player.getScore() == 21 ){
                winners.add(player);
            }
        }
        return winners;
    }
    private void displayScores(Player dealer, Player player){
        System.out.println("Dealer: " + dealer.getScore() + "[" + dealer.getDealerShowScore() + "] Player:" + player.getScore());

    }
}
