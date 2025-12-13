package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

/**
 * Represents the showdown state of the game, where the remaining players reveal their hands
 * to determine the winner. The hands are evaluated, and the winner(s) are identified.
 * The game then transitions to the {@link PayoutState}.
 */
public class ShowdownState implements GameState {

    /**
     * Throws an exception as no player actions are permitted during the Showdown state.
     *
     * @param game The current game context.
     * @param action The action performed by the player.
     * @param playerId The ID of the player performing the action.
     * @throws IllegalActionException always, as no actions are allowed in this state.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        throw new IllegalActionException("No actions are allowed during the Showdown state.");
    }

    /**
     * Called when the game enters the Showdown state. It triggers the process of determining
     * the winner and then transitions the game to the {@link PayoutState}.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        determineWinner(game);
        game.changeGameState(new PayoutState());
    }

    /**
     * Determines the winner(s) of the hand by comparing the hands of all players who
     * have not folded. It uses a {@link common.game.HandEvaluator} to rank the hands.
     *
     * @param game The current game context.
     */
    private void determineWinner(GameContext game) {
        // TODO: Get the list of players remaining in the hand.
        // TODO: For each player, evaluate their hand using the HandEvaluator.
        // TODO: Compare the hand ranks to find the highest-ranking hand(s).
        // TODO: Handle ties and side pots correctly.
        // TODO: Store the winner(s) in the game context so PayoutState can use them.
        // TODO: Notify players of who won and with what hand.
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#SHOWDOWN}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.SHOWDOWN;
    }
}
