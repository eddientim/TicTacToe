import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameRulesTest {

    @Test
    public void shouldCheckForWinHorizontal() {
        GameRules gameRules = new GameRules(new Board(1, 1, 3), 3);
//        GameRules gameRules = new GameRules(board, 3);

        gameRules.play(1, 1); // X
        gameRules.play(1, 2); // O
        gameRules.play(2, 1); // X
        gameRules.play(2, 2); // O
        GameState actual = gameRules.play(3, 1); // X
        assertEquals(GameState.WIN, actual);
    }

    @Test
    public void shouldCheckForWinColumn() {
        GameRules gameRules = new GameRules(new Board(1, 1, 3), 3);
//        GameRules gameRules = new GameRules(board, 3);
        gameRules.play(2, 1); // X
        gameRules.play(1, 1); // O
        gameRules.play(3, 1); // X
        gameRules.play(1, 2); // O
        gameRules.play(2, 2); // X
        GameState actual = gameRules.play(1, 3); // O
        assertEquals(GameState.WIN, actual);
    }

    @Test
    public void shouldCheckForWinTopLeftToBottomRightDiagonal() {
        GameRules gameRules = new GameRules(new Board(1, 1, 3), 3);
//        GameRules gameRules = new GameRules(board, 3);
        gameRules.play(1, 1); // X
        gameRules.play(1, 2); // O
        gameRules.play(2, 2); // X
        gameRules.play(1, 3); // O
        GameState actual = gameRules.play(3, 3); // O
        assertEquals(GameState.WIN, actual);
    }

    @Test
    public void shouldCheckForWinTopRightToBottomLeftDiagonal() {
        GameRules gameRules = new GameRules(new Board(1, 1, 3), 3);
        gameRules.play(1, 3); // X
        gameRules.play(1, 1); // O
        gameRules.play(2, 2); // X
        gameRules.play(1, 2); // O
        gameRules.play(3, 1); // X
        GameState actual = gameRules.play(3, 1); // O
        assertEquals(GameState.WIN, actual);
    }

    @Test
    public void shouldCheckWhenBoardIsFullThenDraw() {
        GameRules gameRules = new GameRules(new Board(1, 1, 3), 3);
        gameRules.play(1, 1);
        gameRules.play(1, 2);
        gameRules.play(1, 3);
        gameRules.play(2, 1);
        gameRules.play(2, 3);
        gameRules.play(2, 2);
        gameRules.play(3, 1);
        gameRules.play(3, 3);
        GameState actual = gameRules.play(3, 2);
        assertEquals(GameState.DRAW, actual);
    }
}
