package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

/**
 * Represents the state where the initial hand of cards is dealt to each active player.
 * After the cards are dealt, the game transitions to the {@link BetFirstState}.
 */
public class DealState implements GameState {

    /**
     * Throws an exception as no player actions are permitted during the Deal state.
     *
     * @param game The current game context.
     * @param action The action performed by the player.
     * @param playerId The ID of the player performing the action.
     * @throws IllegalActionException always, as no actions are allowed in this state.
     */
    @Override
    public void handleAction(GameContext game, PlayerAction action, PlayerId playerId) {
        throw new IllegalActionException("No actions are allowed during the Deal state.");
    }

    /**
     * Called upon entering the Deal state. It triggers the dealing of cards to all active players
     * and then transitions the game to the {@link BetFirstState}.
     *
     * @param game The current game context.
     */
    @Override
    public void onEnter(GameContext game) {
        dealCards(game);
        game.changeGameState(new BetFirstState());
    }

    /**
     * Deals the initial hand of cards to each active player.
     * The number of cards dealt is determined by the {@link common.game.GameConfig}.
     *
     * @param game The current game context.
     */
    private void dealCards(GameContext game) {
        //game.getDealer().dealInitialHand(game.getPlayers());
    }

    /**
     * Returns the enum representation of the current game state.
     *
     * @return {@link GameStateInfo#DEAL}
     */
    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.DEAL;
    }
}
