import exceptions.BoxOccupiedException;
import exceptions.InvalidPieceException;
import exceptions.PieceOutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(3);
    }

    @Test
    public void shouldPlacePieceWithinOnBoard() {
        assertTrue(board.markBox('O', 1, 2));
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenRowIsPlacedOffBoard() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                board.markBox('O', 4, 2));
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenNegativeNumber() {
        assertThrows(PieceOutOfBoundsException.class, () ->
                board.markBox('O', -1, -2));
    }

    @Test
    public void shouldThrowPieceOutOfBoundsExceptionWhenColumnIsPlacedOffBoard() {
        assertThrows(PieceOutOfBoundsException.class, () ->
               board.markBox('X', 1, 4));
    }

    @Test
    public void shouldThrowOccupiedExceptionWhenPieceAlreadyExistsInBox() {
        board.markBox('O', 1, 1);
        assertThrows(BoxOccupiedException.class, () -> board.markBox('X', 1, 1));
    }

    @Test
    public void shouldReturnValidPieces() {
        assertThrows(InvalidPieceException.class, () -> board.markBox('K',1, 2));
    }

    @Test
    public void shouldCheckForRowWin() {
        board.markBox('O', 2, 0);
        board.markBox('O', 2, 1);
        board.markBox('O', 2, 2);

        board.hasWinner();
        assertEquals(GameState.WIN, board.hasWinner());
    }

    @Test
    public void shouldCheckForColumnWin() {

        board.markBox('O', 0, 1);
        board.markBox('O', 1, 1);
        board.markBox('O', 2, 1);

        board.hasWinner();
        assertEquals(GameState.WIN, board.hasWinner());
    }

    @Test
    public void shouldCheckForDiagonalWinTopLeftToBottom() {
        board.markBox('O', 0, 0);
        board.markBox('O', 1, 1);
        board.markBox('O', 2, 2);

        board.hasWinner();
        assertEquals(GameState.WIN, board.hasWinner());
    }

    @Test
    public void shouldCheckForDiagonalWinTopRightToLeft() {
        board.markBox('O', 0, 2);
        board.markBox('X', 2, 2);
        board.markBox('O', 1, 1);
        board.markBox('X', 0, 0);
        board.markBox('O', 2, 0);

        board.hasWinner();
        assertEquals(GameState.WIN, board.hasWinner());
    }

    @Test
    public void shouldCheckIfBoardIsFullThenDraw() {
        board.markBox('O', 0, 0);
        board.markBox('X', 0, 1);
        board.markBox('O', 0, 2);
        board.markBox('X', 1, 0);
        board.markBox('O', 1, 1);
        board.markBox('X', 1, 2);
        board.markBox('O', 2, 0);
        board.markBox('O', 2, 1);
        board.markBox('X', 2, 2);

        assertEquals(GameState.DRAW, board.drawGame());
    }
}

