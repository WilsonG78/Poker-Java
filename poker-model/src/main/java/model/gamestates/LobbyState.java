package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import lombok.Getter;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

/**
 * Represents the pre-game lobby state. In this state, players can join the game.
 * The game transitions to the {@link AnteState} once the minimum number of players has joined.
 */
@Getter
public class LobbyState implements  GameState{
    private final GameStateInfo gameStateInfo = GameStateInfo.LOBBY;

    /**
     * Handles player actions within the lobby. The only allowed action is JOIN.
     * If there are at least two players after joining, the game state changes to {@link AnteState}.
     *
     * @param game The current game context.
     * @param playerAction The action performed by the player.
     * @param playerId The ID of the player performing the action.
     * @throws IllegalActionException if the player action is not JOIN.
     */
    public void handleAction(GameContext game, PlayerAction playerAction, PlayerId playerId){

        if (!playerAction.equals(PlayerAction.JOIN)){
           throw new IllegalActionException("Performed NOT JOIN ACTION IN LOBBY");
        }

        if(game.numberOfPlayers() >=2){
            game.changeGameState(new AnteState());
        }
    }

    /**
     * Called when the game enters the lobby state.
     * Checks if there are already enough players to start the game and transitions
     * to the {@link AnteState} if so.
     *
     * @param game The current game context.
     */
    public void onEnter(GameContext game){
        if(game.numberOfPlayers() >=2){
            game.changeGameState(new AnteState());
        }
    }

}
