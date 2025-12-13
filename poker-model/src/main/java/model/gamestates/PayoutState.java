package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

/**
 * Represents the state where the pot is awarded to the winner or winners of the hand.
 * This state is entered after the showdown, or when only one player remains who has not folded.
 * After the payout is complete, the game transitions to the {@link EndState}.
 */
public class PayoutState implements GameState {

    /**
     * Throws an exception as no player actions are permitted during the Payout state.
     *
     * @param game The current game context.
     * @param action The action performed by the player.
     * @param playerId The ID of the player performing the action.
     * @throws IllegalActionException always, as no actions are allowed in this state.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        throw new IllegalActionException("No actions are allowed during the Payout state.");
    }

    /**
     * Called when the game enters the Payout state. It triggers the pot distribution
     * and then transitions the game to the {@link EndState}.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        distributePot(game);
        game.changeGameState(new EndState());
    }

    /**
     * Distributes the pot to the winning player(s).
     * This method would use the game's pot manager and the list of winners determined
     * in the Showdown state to transfer chips.
     *
     * @param game The current game context.
     */
    private void distributePot(GameContext game) {
        // TODO: Get the winner(s) from the game context (set by ShowdownState).
        // TODO: Use the PotManager to calculate and transfer the winnings.
        // TODO: Handle split pots if necessary.
        // TODO: Notify players of the results and the amounts won.
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#PAYOUT}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.PAYOUT;
    }
}
