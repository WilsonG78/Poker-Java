package common.cards;

public record Card(Suit suit, Rank rank){
    public Rank getRank(){
        return rank;
    }
    public Suit getSuit(){
        return  suit;
    }


}


