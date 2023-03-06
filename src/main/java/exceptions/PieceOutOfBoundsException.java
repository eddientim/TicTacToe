package exceptions;

public class PieceOutOfBoundsException extends RuntimeException {

    public PieceOutOfBoundsException(String message) {
        super(message);
    }
}
