package common;
public enum Suit{
    HEARTS(0),
    DIAMONTS(1),
    CLUBS(2),
    SPADES(3)

    private final int code;

    Suit(int code){
        this.code = code;
    }

    public int code(){
        return code;
    }

    public static SuitFromCode(int code){
        for (Suit s : values()){
            if (s.code == code){ return s}
        }
        throw new IllegalArgumentException("Inavlid code" + code);
    }
}
