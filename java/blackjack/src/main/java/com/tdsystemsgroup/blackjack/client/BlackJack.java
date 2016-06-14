package com.tdsystemsgroup.blackjack.client;

import com.tdsystemsgroup.blackjack.common.model.*;
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

        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        System.out.println("Start a new game! ");
        System.out.print("How many players: ");

        // get their input as a String
        int numbPlayers = scanner.nextInt();

        BlackJackServer server = new BlackJackServer();
        Integer gameId = server.create(numbPlayers);

        List<PlayerDisplay> players = server.getPlayers(gameId);
        Dealer dealer = server.getDealer(gameId);

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
                if (dealResponse.getStatus().equals(ServerResponse.BUSTED) || dealResponse.getStatus().equals(ServerResponse.WINNER)){
                  break;
                }
                System.out.print("Enter H to hit, S to stay: ");
                // get their input as a String
                cmd = scanner.next();

            }
        }
        while (dealer.getScore() < 16) {
            try {
                DealResponse dealResponse = server.deal(gameId, dealer.getPlayerId());
                displayDealResponse(dealResponse);
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
        GameResponse gameResponseOver = server.gameStatus(gameId);
        displayGameStatus(gameResponseOver);


        server.finish(gameId);

    }

    private void displayScores(Dealer dealer, PlayerDisplay player) {
        System.out.println("Dealer: " + dealer + " " + player);
    }

    private void displayDealResponse(DealResponse resp) {
        System.out.println("Card dealt " +resp.getCard());
        System.out.println(resp.getDisplayMessage());
        System.out.println(resp.getScore());
        System.out.println(resp.getStatus());
    }

    private void displayGameStatus(GameResponse resp) {
        System.out.println(resp.getDealerStatus());
        for (PlayerDisplay player : resp.getPlayerStatus()) {
            System.out.println(player.getName());
            System.out.println(player.getCardDisplay());
            System.out.println(player.getScore());
            System.out.println(player.getStatus());
        }
    }
    private void dumpPlayer(Player p) {
            System.out.println(p);
    }

}

