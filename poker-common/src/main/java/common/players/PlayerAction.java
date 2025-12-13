package common.players;

public enum PlayerAction {
    RAISE(0),
    PASS(1),
    CHECK(2),
    CHANGE(3),
    JOIN(4);

    private final int code;

    PlayerAction(int code){
        this.code = code;
    }

    public int code(){
        return code;
    }

    public PlayerAction actionFromCode(int code){
        for (PlayerAction a : values()){
            if (a.code == code){ return a;}
        }
        throw new IllegalArgumentException("Inavlid value" + code);
    }
}
