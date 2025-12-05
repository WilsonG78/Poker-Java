package common;

public enum Rank {
    TWO(0),
    THREE(1),
    FOUR(2),
    FIVE(3),
    SIX(4),
    SEVEN(5),
    EIGHT(6),
    NINE(7),
    TEN(8),
    JACK(9),
    QUEEN(10),
    KING(11),
    ACE(12);


    private final int code;

    Rank(int code){
        this.code = code;
    }

    public int code(){
        return code;
    }

    public static RankFromCode(int code){
        for (Rank r : values()){
            if (r.code == code){ return r}
        }
        throw new IllegalArgumentException("Inavlid code" + code);
    }
}
