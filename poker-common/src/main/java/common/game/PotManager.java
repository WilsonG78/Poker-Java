package common.game;

import common.players.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PotManager {
    private int currentPot;
    private int currentBet;
    private List<Player> players;
}
