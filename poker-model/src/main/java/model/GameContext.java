package model;

import common.cards.Card;
import common.cards.Deck;
import common.game.GameConfig;
import common.game.GameId;
import common.game.Round;
import common.players.Player;
import common.players.PlayerId;
import lombok.Data;
import model.gamestates.GameState;
import model.gamestates.LobbyState;

import java.util.ArrayList;


@Data
public class GameContext {
    private GameState gameState = new LobbyState();
    private GameConfig gameConfig;
    private GameId gameId;
    private ArrayList<Player> players;
    private PlayerId dealer;
    private Deck deck;
    private Round round;
    public void changeGameState(GameState newGameState){
        gameState = newGameState;
    }

    public int numberOfPlayers(){
        return players.size();
    }
    protected Card dealCard(){
        return deck.dealCard();
    }


}
