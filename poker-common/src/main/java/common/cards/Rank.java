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

    public static Rank fromString(String text){
        switch (text.toUpperCase()) {
            case "2":
                return Rank.TWO;
            case "3":
                return Rank.THREE;
            case "4":
                return Rank.FOUR;
            case "5":
                return Rank.FIVE;
            case "6":
                return Rank.SIX;
            case "7":
                return Rank.SEVEN;
            case "8":
                return Rank.EIGHT;
            case "9":
                return Rank.NINE;
            case "10":
                return Rank.TEN;
            case "J":
                return Rank.JACK;
            case "Q":
                return Rank.QUEEN;
            case "K":
                return Rank.KING;
            case "A":
                return Rank.ACE;
            default:
                throw new IllegalArgumentException("Unknown rank: " + text);
        }
    }

}
