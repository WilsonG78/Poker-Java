package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;

/**
 * Represents the second round of betting in the poker game.
 * This state is entered after an intermediate action, such as the drawing of cards in Five-Card Draw
 * or the "turn" card in Texas Hold'em. Players can again BET, CHECK, RAISE, or FOLD.
 * After this round, the game typically proceeds to a showdown or another final state.
 */
public class BetSecondState implements GameState {

    /**
     * Handles player actions related to the second betting round.
     * This method will contain the logic to process a player's move (e.g., BET, CHECK, FOLD).
     *
     * @param game The current game context.
     * @param action The betting action performed by the player.
     * @param playerId The ID of the player performing the action.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        // TODO: Implement betting logic for the second round.
        // TODO: Validate player's turn and action.
        // TODO: Update player and pot state.
        // TODO: Check if the betting round is over and change state to ShowdownState.
    }

    /**
     * Called when the game enters the second betting round.
     * This method can be used to initialize the round, setting up the turn order
     * and prompting the first player to act.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        // TODO: Initialize the second betting round.
        // TODO: Set up the turn order.
        // TODO: Notify players that the second betting round has started.
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#BET_SECOND}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.BET_SECOND;
    }
}
