package common.cards;

public enum Suit{
    HEARTS(0),
    DIAMONDS(1),
    CLUBS(2),
    SPADES(3);

    private final int value;

    Suit(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }

    public Suit suitFromCode(int value){
        for (Suit s : values()){
            if (s.value == value){ return s;}
        }
        throw new IllegalArgumentException("Inavlid value" + value);
    }
}
