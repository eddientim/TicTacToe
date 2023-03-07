public class Game {

    private Board board;

    public Game() {
        board = new Board();
    }

    public GameState play() {
        return GameState.NO_WINNER;
    }
}
