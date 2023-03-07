public class Game {

    private Board board;

    public Game() {
        board = new Board(3);
    }

    public GameState play() {
        return GameState.NO_WINNER;
    }
}
