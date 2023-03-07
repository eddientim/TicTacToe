package exceptions;

public class InvalidPieceException extends RuntimeException {
    public InvalidPieceException(String message) {
        super(message);
    }
}
