package model.pokerexceptions;

public class InvalidMoveException extends RuntimeException {
    public final String code;
    public InvalidMoveException(String code, String msg){
        super(msg); this.code = code;
    }
}
