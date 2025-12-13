package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import lombok.Getter;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

@Getter
public class LobbyState implements  GameState{
    private final GameStateInfo gameStateInfo = GameStateInfo.LOBBY;

    public void handleAction(GameContext game, PlayerAction playerAction, PlayerId playerId){

        if (!playerAction.equals(PlayerAction.JOIN)){
           throw new IllegalActionException("Performed NOT JOIN ACTION IN LOBBY");
        }

        if(game.numberOfPlayers() >=2){
            game.changeGameState(new AnteState());
        }
    }

    public void onEnter(GameContext game){
        if(game.numberOfPlayers() >=2){
            game.changeGameState(new AnteState());
        }
    }

}
