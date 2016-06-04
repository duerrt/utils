package com.tdsystemsgroup.blackjack.client;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.server.BlackJackServer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by duerrt on 8/17/15.
 */
public class BlackJack {


    public static void main(String[] args) {

        BlackJack client = new BlackJack();
        client.play();

    }

    private void play(){

        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        System.out.println("Start a new game! ");
        System.out.print("How many players: ");

        // get their input as a String
        int numbPlayers = scanner.nextInt();

        BlackJackServer server = new BlackJackServer();
        Integer gameId = server.create(numbPlayers);

        ArrayList<Card.Player> players = server.getPlayers(gameId);
        Card.Player dealer = null;
        if (players.get(0).isDealer()){
            dealer = players.get(0);
            players.remove(0);
        }

        initialDeal(gameId,server, dealer, players);
        for (Card.Player player : players) {

            if (player.isDealer()) {
                continue;
            }

            displayScores(dealer, player);
            // create a scanner so we can read the command-line input
            scanner = new Scanner(System.in);
            //  prompt for the user's name
            System.out.print("Enter H to hit, S to stay: ");

            // get their input as a String
            String cmd = scanner.next();

            while (cmd.toLowerCase().equals("h")) {
                try {
                    player.addCard(server.deal(gameId));
                    displayScores(dealer, player);
//                    dumpPlayer(player);
                } catch (Exception e) {
                    System.out.println("Sorry you busted");
                    player.setStatus("Busted");
                    break;
                }
                if (player.getScore() == 21){
                    System.out.print("WINNER!!");
                    player.setStatus("Winner");
                    break;
                }
                System.out.print("Enter H to hit, S to stay: ");
                // get their input as a String
                cmd = scanner.next();

            }
        }
        while (dealer.getScore() < 16) {
            try {
                dealer.addCard(server.deal(gameId));
                dumpPlayer(dealer);
            } catch (Exception e) {
                System.out.println("Dealer busted. You WON!!");
                dealer.setStatus("Busted");
                //dumpPlayer(dealer);
                //2return;
            }
        }
        if (dealer.getScore() == 21){
            dealer.setStatus("Winner");
        }
        System.out.println("---Game Over---");
        System.out.println("Dealer:"+dealer.getScore());

        for (Card.Player player : players) {
            if (player.isDealer()) {
                continue;
            }

            if (! player.getStatus().equals("Buster") && ! player.getStatus().equals("Winner")){
                if (player.getScore() == dealer.getScore()){
                    player.setStatus("Push");
                } else if (player.getScore() < dealer.getScore()){
                    player.setStatus("Loser");
                } else {
                    player.setStatus("Winner");
                }
            }
            System.out.println(player.getName()+":"+player.getScore()+":"+player.getStatus());

        }

        server.finish(gameId);

    }

    private void initialDeal(Integer gameId, BlackJackServer server, Card.Player dealer, ArrayList<Card.Player> players ) {

        try {
            dealer.addCard(server.deal(gameId));
            dealer.addCard(server.deal(gameId));
        } catch (Exception e) {
            System.out.println("wont happen");
        }

        for (Card.Player player : players) {
            if (player.isDealer()) {
                continue;
            }

            try {
                player.addCard(server.deal(gameId));
            } catch (Exception e) {
                System.out.println("wont happen");
            }
        }

    }

    private void displayScores(Card.Player dealer, Card.Player player) {
        System.out.println("Dealer: " + dealer.getScore() + "[" + dealer.getDealerShowScore() + "] " + player.getName() + ":" + player.getScore());

    }

    private void dumpPlayer(Card.Player p) {
        for (Card c : p.getCards()) {
            System.out.println(p.getName() + " - Card: " + c.getLabel() + " " + c.getValue());
        }
    }

}

