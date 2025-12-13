package model.gamestates;

import common.game.GameStateInfo;
import common.players.Player;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

/**
 * Represents the state where each active player must post an ante before the cards are dealt.
 * After collecting antes, the game transitions to the {@link DealState}.
 */
public class AnteState implements GameState{
    /**
     * Throws an exception as no player actions are permitted during the Ante state.
     *
     * @param game The current game context.
     * @param playerAction The action performed by the player.
     * @param playerId The ID of the player performing the action.
     * @throws IllegalActionException always, as no actions are allowed in this state.
     */
    public void handleAction(GameContext game,  PlayerAction playerAction,PlayerId playerId){
        throw new  IllegalActionException("No actions are allowed during the Ante state.");
    }

    /**
     * Called upon entering the Ante state. It triggers the collection of antes from all active players
     * and then transitions the game to the {@link DealState}.
     *
     * @param game The current game context.
     */
    public void onEnter(GameContext game){
        collectAnte(game);
        game.changeGameState(new DealState());
    }

    /**
     * Collects the ante from each active player in the game.
     * The ante amount is defined in the {@link common.game.GameConfig}.
     *
     * @param game The current game context.
     */
    protected void collectAnte(GameContext game){
        for (Player player : game.getPlayers()){
            if (player.isActive()){
                player.setChips(player.getChips() - game.getGameConfig().getAnte());
            }
        }
    }

    @Override
    public GameStateInfo getGameStateInfo() {
        return GameStateInfo.ANTE;
    }
}
