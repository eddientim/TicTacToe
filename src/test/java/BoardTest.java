import exceptions.BoxOccupiedException;
import exceptions.PieceOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void shouldPlacePieceWithinOnBoard() {

        Board board = new Board();

        boolean actual = board.markBox('O', 1, 2);

        assertTrue(actual);
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenRowIsPlacedOffBoard() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                new Board().markBox('O', 4, 2));
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenNegativeNumber() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                new Board().markBox('O', -1, -2));
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenColumnIsPlacedOffBoard() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                new Board().markBox('X', 1, 4));
    }

    @Test
    public void shouldThrowOccupiedExceptionWhenPieceAlreadyExistsInBox() {

        Board board = new Board();
        board.markBox('O', 1, 1);
        assertThrows(BoxOccupiedException.class, () -> board.markBox('X', 1, 1));
    }

    @Test
    public void shouldCheckForRowWin() {
        Board board = new Board();

        board.markBox('0',2,0);
        board.markBox('0',2,1);
        board.markBox('0',2,2);

        board.hasWinner();
        assertTrue(board.hasWinner());
    }

    @Test
    public void shouldCheckForColumnWin() {
        Board board = new Board();

        board.markBox('0',0,1);
        board.markBox('0',1,1);
        board.markBox('0',2,1);

        board.hasWinner();
        assertTrue(board.hasWinner());
    }

    @Test
    public void shouldCheckForDiagonalWinTopLeftToBottom() {
        Board board = new Board();

        board.markBox('0',0,0);
        board.markBox('0',1,1);
        board.markBox('0',2,2);

        board.hasWinner();
        assertTrue(board.hasWinner());
    }

    @Test
    public void shouldCheckForDiagonalWinTopRightToLeft() {
        Board board = new Board();

        board.markBox('0',0,2);
        board.markBox('0',1,1);
        board.markBox('0',2,0);

        board.hasWinner();
        assertTrue(board.hasWinner());
    }
}

