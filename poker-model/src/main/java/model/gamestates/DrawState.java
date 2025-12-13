package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;

/**
 * Represents the state where players can discard a number of cards and draw new ones from the deck.
 * This state is central to "draw poker" variants. After the draw phase is complete for all players,
 * the game transitions to the {@link BetSecondState}.
 */
public class DrawState implements GameState {

    /**
     * Handles the DRAW action from a player. Players can specify which cards they wish to discard.
     * The dealer will then provide new cards from the deck.
     *
     * @param game The current game context.
     * @param action The action performed by the player, expected to be DRAW.
     * @param playerId The ID of the player performing the action.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        // TODO: Implement draw logic. Expect a DRAW action with a list of cards to discard.
        // TODO: Validate the player's request (e.g., number of cards to discard is within limits).
        // TODO: Remove discarded cards from the player's hand.
        // TODO: Deal new cards to the player from the deck.
        // TODO: Manage turn order for drawing.
        // TODO: When all players have had a chance to draw, transition to BetSecondState.
    }

    /**
     * Called when the game enters the Draw state.
     * This method can be used to notify players that the draw phase has begun
     * and prompt the first player to act.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        // TODO: Initialize the draw phase.
        // TODO: Set up the turn order for drawing.
        // TODO: Notify players that the draw phase has started.
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#DRAW}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.DRAW;
    }
}
