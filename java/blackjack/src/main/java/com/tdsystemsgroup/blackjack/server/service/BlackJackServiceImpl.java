package com.tdsystemsgroup.blackjack.server.service;

import com.tdsystemsgroup.blackjack.common.model.*;
import com.tdsystemsgroup.blackjack.common.model.Card;
import com.tdsystemsgroup.blackjack.server.BlackJackServer;
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

    private static int baseGameId = 1000;

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

        Game game = new Game();
        game.setId(getNextId());
        Deck deck = new Deck();
        game.setDeck(deck);

        ArrayList<Player> players = new ArrayList<>();

        Dealer dealer = new Dealer();
        game.setDealer(dealer);

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player_" + i));
        }

        game.setPlayers(players);

        if (games == null){
            games = new HashMap<>();
        }
        Map<Integer, Game> safeGames = new HashMap<>();
        for (Map.Entry<Integer, Game> entry : games.entrySet())
        {
            safeGames.put(entry.getKey(),entry.getValue());
        }
        safeGames.put(game.getId(), game);
        games = safeGames;

        initialDeal(game.getId(), dealer, players);

        return game.getId();
    }

    private void initialDeal(Integer gameId, Dealer dealer, ArrayList<Player> players ) {

        try {
            dealer.addCard(getNextCard(gameId));
            System.out.println("Deal 1 " + dealer.getCards().get(0));
        dealer.addCard(getNextCard(gameId));
            System.out.println("Deal 2 " + dealer.getCards().get(1));
        } catch (Exception e) {
            System.out.println("wont happen");
        }

        for (Player player : players){
            try {
                player.addCard(getNextCard(gameId));
                player.addCard(getNextCard(gameId));
            } catch (Exception e) {
                System.out.println("wont happen");
            }
        }


    }

    @Override
    public GameResponse gameStatus(Integer gameId) {
        GameResponse gameResp = new GameResponse();
        gameResp.setDealerStatus((games.get(gameId).getDealer().toString()));
        StringBuilder playerStatus = new StringBuilder();
        List<Player> players = games.get(gameId).getPlayers();
        List<PlayerDisplay> retPlayers = new ArrayList<>();
        for (Player p : players) {
            PlayerDisplay pd = new PlayerDisplay();
            pd.setName(p.getName());
            pd.setPlayerId(p.getPlayerId());
            String score = (p.getScore() == p.getMinScore()) ? ""+p.getScore() : ""+p.getScore()+"/"+p.getMinScore();
            pd.setScore(score);

            StringBuilder cardDisplay = new StringBuilder();
            for (Card c : p.getCards()){
                cardDisplay.append(c.toString());
                cardDisplay.append(" ");
            }
            pd.setCardDisplay(cardDisplay.toString());
            if (p.getScore() == 21){
                pd.setStatus(ServerResponse.WINNER);
            } else {
                pd.setStatus("");
            }

            retPlayers.add(pd);
        }
        gameResp.setPlayerStatus(retPlayers);

        return gameResp;
    }


    @Override
    public DealResponse deal(Integer gameId, Integer playerId) {
        DealResponse dealResp = new DealResponse();
        Game game = games.get(gameId);
        Player p = null;
        Card dealt = null;
        if (game.getDealer().getPlayerId().equals(playerId)) {
            p = game.getDealer();
        } else {
            ArrayList<Player> players = game.getPlayers();
            for (Player player : players) {
                if (player.getPlayerId().equals(playerId)){
                    p = player;
                } else {
                    continue;
                }
            }
        }
        try {
            dealt = getNextCard(gameId);
            p.addCard(dealt);
        } catch (Exception e) {
            dealResp.setCard(dealt.toString());
            dealResp.setStatus(DealResponse.BUSTED);
            dealResp.setDisplayMessage(e.getMessage());
            return dealResp;
        }

        if (p.getScore() == 21){
            dealResp.setCard(dealt.toString());
            dealResp.setScore(p.getScore());
            dealResp.setStatus(DealResponse.WINNER);
            dealResp.setDisplayMessage("Winner!");

            return dealResp;
        }
        dealResp.setCard(dealt.toString());
        dealResp.setScore(p.getScore());
        dealResp.setStatus(DealResponse.ACTIVE);
        dealResp.setDisplayMessage("");
        return dealResp;
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

    private Card getNextCard(Integer gameId) {
       Deck deck = games.get(gameId).getDeck();
       return deck.deal();
    }

    /**
     * get the list of players
     * @param gameId
     * @return ArrayList<Player>
     */
    public List<PlayerDisplay> getPlayers(Integer gameId) {
        ArrayList<Player> players = games.get(gameId).getPlayers();
        List<PlayerDisplay> playerDisplay = new ArrayList<>();
        for (Player p : players){
            PlayerDisplay pd = new PlayerDisplay();
            pd.setName(p.getName());
            pd.setPlayerId(p.getPlayerId());
            String score = (p.getScore() == p.getMinScore()) ? ""+p.getScore() : ""+p.getScore()+"/"+p.getMinScore();
            pd.setScore(score);
            playerDisplay.add(pd);
        }
        return playerDisplay;
    }

    /**
     * get the dealer
     * @param gameId
     * @return Dealer
     */
    public Dealer getDealer(Integer gameId) {
        return games.get(gameId).getDealer();
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
        baseGameId += 1;
        return baseGameId;
    }



}
