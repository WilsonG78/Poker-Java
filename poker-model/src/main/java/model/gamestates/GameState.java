package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;

/**
 * Represents a state in the poker game following the State design pattern.
 * Each implementation of this interface defines a specific phase of the game,
 * such as betting, dealing, or showdown.
 */
public interface GameState {
    /**
     * Handles a player's action within the current game state.
     *
     * @param game The context of the game.
     * @param action The action performed by the player.
     * @param playerId The ID of the player performing the action.
     */
    void handleAction(GameContext game, PlayerAction action, PlayerId playerId);

    /**
     * Executes logic that should run when the game transitions into this state.
     *
     * @param game The context of the game.
     */
    void onEnter(GameContext game);

    /**
     * Returns the enum representation of the current game state.
     *
     * @return A {@link GameStateInfo} enum value.
     */
    GameStateInfo getGameStateInfo();
}
