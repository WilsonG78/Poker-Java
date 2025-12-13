package common.players;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerId {
    int id;
    public static PlayerId fromString(String text){
        int newId =  Integer.parseInt(text);
        return new PlayerId(newId);
    }
}
