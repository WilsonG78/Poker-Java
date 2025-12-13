package common.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameId {
    private int id;
    public static GameId fromString(String text){
        int id =Integer.parseInt(text);
        return new GameId(id);
    }
}
