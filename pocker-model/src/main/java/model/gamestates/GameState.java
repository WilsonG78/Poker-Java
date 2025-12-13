package model.gamestates;

import common.game.GameStateInfo;
import common.players.PlayerAction;
import common.players.PlayerId;
import model.GameContext;

public interface GameState {
    void handleAction(GameContext game, PlayerAction action, PlayerId playerId);
    void onEnter(GameContext game);
    GameStateInfo getGameStateInfo();
}
