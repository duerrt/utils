package com.tdsystemsgroup.blackjack.client;

import com.tdsystemsgroup.blackjack.common.model.*;
import com.tdsystemsgroup.blackjack.server.BlackJackResource;
import com.tdsystemsgroup.blackjack.server.BlackJackServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by duerrt on 8/17/15.
 */
public class BlackJack {


    public static void main(String[] args) {

        BlackJack client = new BlackJack();
        client.play();

    }

    /**
     * Play the game
     */
    private void play(){

        int numbPlayers = getNumberOfPlayers();
        Scanner scanner;

        BlackJackResource server = new BlackJackResource();
        Integer gameId = server.create(numbPlayers);

        List<PlayerDisplay> players = server.getPlayers(gameId);
   //     Dealer dealer = server.getDealer(gameId);

        GameResponse gameResponse = server.gameStatus(gameId);
        displayGameStatus(gameResponse);
        for (PlayerDisplay player : players) {

            if (player.getStatus() == ServerResponse.WINNER) {
                continue;
            }

            // create a scanner so we can read the command-line input
            scanner = new Scanner(System.in);
            //  prompt for the user's name
            System.out.print("Enter H to hit, S to stay: ");

            // get their input as a String
            String cmd = scanner.next();

            while (cmd.toLowerCase().equals("h")) {
                DealResponse dealResponse = server.deal(gameId,player.getPlayerId());
                displayDealResponse(dealResponse);
                if (dealResponse.getStatus().equals(ServerResponse.BUSTED) ||
                        dealResponse.getStatus().equals(ServerResponse.WINNER) ||
                        dealResponse.getStatus().equals(ServerResponse.BLACKJACK)){
                  break;
                }
                System.out.print("Enter H to hit, S to stay: ");
                // get their input as a String
                cmd = scanner.next();

            }
        }
        GameResponse gameResponseOver = server.finish(gameId);

        System.out.println("---Game Over---");
        displayGameStatus(gameResponseOver);

    }

    private int getNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        System.out.println("Start a new game! ");
        System.out.print("How many players: ");

        // get their input as a String
        return scanner.nextInt();
    }

    private void displayScores(Dealer dealer, PlayerDisplay player) {
        System.out.println("Dealer: " + dealer + " " + player);
    }

    private void displayDealResponse(DealResponse resp) {
        System.out.println("Card dealt: " +resp.getCard());
        System.out.println("score: "+resp.getScore());
        System.out.println("status: "+resp.getStatus());
    }

    private void displayGameStatus(GameResponse resp) {
        System.out.println(resp.getDealerStatus());
//       System.out.println("dealer score: " + resp.getDealerStatus().getVisibleScore());
//        System.out.println("dealer card: " + resp.getDealerStatus().getVisibleCard());
//        System.out.println("dealer status: " + resp.getDealerStatus().getStatus());

        for (PlayerDisplay player : resp.getPlayerStatus()) {
            System.out.println(player);
            /*
            System.out.println("Player: " + player.getName());
            System.out.println("cards: " + player.getCardDisplay());
            System.out.println("score: " + player.getScore());
            System.out.println("status: " + player.getStatus());
 */
        }
    }
    private void dumpPlayer(Player p) {
            System.out.println(p);
    }

}

