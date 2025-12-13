package common.cards;

public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);


    private final int value;

    Rank(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }


    public Rank rankFromValue(int value){
        for (Rank r : values()){
            if (r.value == value){ return r;}
        }
        throw new IllegalArgumentException("Inavlid value" + value);
    }

    @Override
    public String toString(){
        if(value < 11){
            return Integer.toString(value);
        } else if (value == 11) {
            return "J";
        }
        else if (value ==12) {
            return "Q";
        } else if (value ==13){
            return "K";
        }
        else {
            return "A";
        }

    }

}
