package common.exceptions;

public class IllegalCardInDeckException extends RuntimeException{

    public IllegalCardInDeckException(String msg){
        super(msg);
    }
}
