package common.cards;

public enum Suit{
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C"),
    SPADES("S");

    private final String symbol;

    Suit(String s){
        this.symbol = s;
    }


    public static Suit fromString(String sym){
        for (Suit s : values()){
            if (s.symbol == sym){ return s;}
        }
        throw new IllegalArgumentException("Inavlid value" + sym);
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

}
