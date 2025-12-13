package common.players;


import common.game.GameId;
import common.game.GameStateInfo;
import common.game.Hand;
import common.game.Pot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Player{

    private final PlayerId playerId;
    private final GameId gameId;
    private int chips;
    private Pot pot;
    private boolean active;
    private boolean dealer;
    private PlayerState playerState;
    private Hand hand;
    private PlayerAction lastAction;
    private GameStateInfo gameStateInfo;


}
