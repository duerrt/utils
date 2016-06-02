package com.tom.blackjack;

import com.tom.blackjack.model.Card;
import com.tom.blackjack.model.Deck;
import com.tom.blackjack.model.Player;
import com.tom.blackjack.model.Game;

import com.tom.blackjack.service.BlackJackService;
import com.tom.blackjack.service.BlackJackServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by duerrt on 8/17/15.
 */
public class BlackJack {


    public static void main(String[] args) {


        BlackJackService bJack = new BlackJackServiceImpl();

        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        System.out.println("Start a new game! ");
        System.out.print("How many players: ");

        // get their input as a String
        int numbPlayers = scanner.nextInt();

        Game game = bJack.create(numbPlayers);

    }

    private void dumpPlayer(Player p){
       for (Card c : p.getCards()){
           System.out.println(p.getName() + " - Card: " + c.getLabel() + " " + c.getValue());
       }

    }

    private void initialDeal(Deck deck, Player dealer, Player player1){
        Card dealerHole = deck.deal();
        Card dealerShow = deck.deal();

        try {
            dealer.addCard(dealerHole);
            dealer.addCard(dealerShow);
        } catch (Exception e) {
            System.out.println("wont happen");
        }
//        System.out.println("dealer has " + dealer.getDealerShowScore() + " showing");
     //   dumpPlayer(dealer);

        Card c1 = deck.deal();
        Card c2 = deck.deal();

        try {
            player1.addCard(c1);
            player1.addCard(c2);
        } catch (Exception e) {
            System.out.println("wont happen");
        }
  //      System.out.println("You have " + player1.getScore());
       // dumpPlayer(player1);

        if (dealer.getScore() == 21 ){
            System.out.println("Dealer got blackjack");
        }
        if (player1.getScore() == 21 ){
            System.out.println("You got blackjack!!!");
        }
    }

    private void deal(Deck deck, Player player1) throws Exception{
        player1.addCard(deck.deal());
    }

    private List<Player> getWinners(){
        List<Player> winners = new ArrayList<>();
        return winners;
    }
}

