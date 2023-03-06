import exceptions.BoxOccupiedException;
import exceptions.PieceOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void shouldPlacePieceWithinOnBoard() {

        Board board = new Board(1, 1, 3);

        boolean actual = board.markBox('O');

        assertTrue(actual);
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenRowIsPlacedOffBoard() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                new Board(4, 1, 3).pieceOutOfBounds());
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenColumnIsPlacedOffBoard() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                new Board(1, 5, 3).pieceOutOfBounds());
    }

    @Test
    public void shouldThrowOccupiedExceptionWhenPieceAlreadyExistsInBox() {

        Board board = new Board(1, 1, 3);
        assertThrows(BoxOccupiedException.class, () -> board.markBox('X'));
    }
}

