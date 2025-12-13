package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;

/**
 * Represents the first round of betting in the poker game.
 * In this state, players can perform actions like BET, CHECK, RAISE, or FOLD.
 * The state ends when the betting round is complete, and transitions to the next logical state,
 * which could be the draw phase or the next dealing phase, depending on the game rules.
 */
public class BetFirstState implements GameState {

    /**
     * Handles player actions related to betting.
     * This method will contain the logic to process a player's move (e.g., BET, CHECK, FOLD).
     *
     * @param game The current game context.
     * @param action The betting action performed by the player.
     * @param playerId The ID of the player performing the action.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        // TODO: Implement betting logic: handle BET, CHECK, RAISE, FOLD actions.
        // TODO: Validate player's turn and action.
        // TODO: Update player and pot state.
        // TODO: Check if the betting round is over and change state if it is.
    }

    /**
     * Called when the game enters the first betting round.
     * This method can be used to initialize the betting round, for example,
     * by setting up the turn order and prompting the first player to act.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        // TODO: Initialize the betting round.
        // TODO: Set up the turn order based on game rules (e.g., player after the big blind).
        // TODO: Notify players that the betting round has started.
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#BET_FIRST}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.BET_FIRST;
    }
}
