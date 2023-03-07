import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldDetectXWinner() {
        Game game = new Game();

        game.play();

        assertEquals(GameState.WIN, game.play());
    }

    @Test
    public void shouldDetectYWinner() {

    }

}
