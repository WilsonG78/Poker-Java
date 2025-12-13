package model.pokerexceptions;

public final class OutOfTurnException extends InvalidMoveException {
    public OutOfTurnException(){
        super("OUT_OF_TURN","Not your turn");
    }
}
