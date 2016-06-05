package com.tdsystemsgroup.blackjack.server.service;

import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.common.model.Player;
import com.tdsystemsgroup.blackjack.server.model.Deck;
import com.tdsystemsgroup.blackjack.server.model.Game;

import java.util.*;

/**
 * Singleton BlackJackServoice to provide server based
 * blackjack processing
 *
 * Created by duerrt on 5/30/16.
 */
public class BlackJackServiceImpl implements GameService {

    private static int baseId = 1000;

    Map<Integer, Game> games = null;

    private static BlackJackServiceImpl instance = null;

    protected BlackJackServiceImpl() {
        // Exists only to defeat instantiation.
    }
    public static BlackJackServiceImpl getInstance() {
        if(instance == null) {
            instance = new BlackJackServiceImpl();
        }
        return instance;
    }


    @Override
    public Integer create(int numberOfPlayers) {

        games = new HashMap<>();

        Game game = new Game();
        game.setId(getNextId());
        Deck deck = new Deck();
        game.setDeck(deck);

        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(true, "Dealer"));

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(false, "Player" + i));
        }

        game.setPlayers(players);

        if (games == null) {
            games = new HashMap<>();
        }
        games.put(game.getId(), game);

        Map<Integer, Game> safeGames = new HashMap<>();
        for (Map.Entry<Integer, Game> entry : games.entrySet())
        {
            safeGames.put(entry.getKey(),entry.getValue());
        }
        safeGames.put(game.getId(), game);
        games = safeGames;
        return game.getId();
    }

    @Override
    public void finish(Integer gameId) {
        Map<Integer, Game> safeGames = new HashMap<>();
        for (Map.Entry<Integer, Game> entry : games.entrySet())
        {
            if (gameId.equals(entry.getKey())){
                continue;
            }
            safeGames.put(entry.getKey(),entry.getValue());
        }
        games = safeGames;

    }

    public Card deal(Integer gameId) {
        Deck deck = games.get(gameId).getDeck();
        return deck.deal();
    }


    public ArrayList<Player> getPlayers(Integer gameId) {
        return games.get(gameId).getPlayers();
    }
/*
    @Override
    public void play(Integer gameId) {


        ArrayList<Player> players = games.get(gameId).getPlayers();

        Player dealer = games.get(gameId).getDealer();

        Deck deck = games.get(gameId).getDeck();


        for (Player player : players) {

            if (player.isDealer()) {
                continue;
            }
           // displayScores(dealer, player);
            // create a scanner so we can read the command-line input
            Scanner scanner = new Scanner(System.in);
            //  prompt for the user's name
            System.out.print("Enter H to hit, S to stay: ");

            // get their input as a String
            String cmd = scanner.next();

            while (cmd.toLowerCase().equals("h")) {
                try {
                    player.addCard(games.get(gameId).getDeck().deal());
             //       displayScores(dealer, player);
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
                dealer.addCard(deck.deal());
               // dumpPlayer(dealer);
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

        for (Player player : players) {
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


    }

    @Override
    public void start(Integer gameId) {
        Player dealer = games.get(gameId).getDealer();
        Deck deck = games.get(gameId).getDeck();
        try {
            dealer.addCard(deck.deal());
            dealer.addCard(deck.deal());
        } catch (Exception e) {
            System.out.println("wont happen");
        }

        for (Player player : games.get(gameId).getPlayers()) {
            if (player.isDealer()) {
                continue;
            }

            try {
                player.addCard(deck.deal());
            } catch (Exception e) {
                System.out.println("wont happen");
            }
        }

    }
*/
    private synchronized Integer getNextId() {
        baseId += 1;
        return baseId;
    }



}
