package model.gamestates;

import common.players.Player;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;
import model.pokerexceptions.IllegalActionException;

public class AnteState implements GameState{
    public void handleAction(GameContext game,  PlayerAction playerAction,PlayerId playerId){
        throw new  IllegalActionException("Performed Action when");
    }
    public void onEnter(GameContext game){

    }

    protected void collectAnte(GameContext game){

        for (Player player : game.getPlayers()){
            if (player.isActive()){
                player.setChips(player.getChips() - game.getGameConfig().getAnte());
            }
        }
    }

}
