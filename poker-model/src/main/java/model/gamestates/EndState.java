package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

/**
 * Represents the end of a poker round. This state is responsible for cleaning up the game board,
 * resetting player statuses, and preparing for the next round of play.
 * After cleanup, it may transition back to the {@link AnteState} to start a new round.
 */
public class EndState implements GameState {

    /**
     * Throws an exception as no player actions are permitted during the End state.
     *
     * @param game The current game context.
     * @param action The action performed by the player.
     * @param playerId The ID of the player performing the action.
     * @throws IllegalActionException always, as no actions are allowed in this state.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        throw new IllegalActionException("No actions are allowed during the End state.");
    }

    /**
     * Called when the game enters the End state. It triggers the cleanup and reset procedures
     * for the next round.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        resetForNextRound(game);
        // TODO: Decide on the transition. Should it automatically start a new round,
        // or wait for a "start new round" command? For now, we can transition to AnteState.
        game.changeGameState(new AnteState());
    }

    /**
     * Resets the game context for the next round. This includes clearing player hands,
     * resetting the pot, preparing the deck, and updating player statuses.
     *
     * @param game The current game context.
     */
    private void resetForNextRound(GameContext game) {
        // TODO: Reset player hands and statuses (e.g., hasFolded).
        // TODO: Reset the pot manager.
        // TODO: Shuffle the deck.
        // TODO: Move the dealer button to the next player.
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#END}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.END;
    }
}
