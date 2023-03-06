public class GameRules implements Player {

    private char lastPlayer;
    private final Board board;
    private final int boardSize;

    public GameRules(Board board, int boardSize) {
        this.board = board;
        this.boardSize = boardSize;
    }

    public GameState play(int row, int column) {
        board.pieceOutOfBounds();
        board.markBox(lastPlayer);

        if (win(row, column) == GameState.WIN) {
            return GameState.WIN;
        } else if (draw() == GameState.DRAW) {
            return GameState.DRAW;
        } else {
            return GameState.NO_WIN;
        }
    }

    private GameState win(int row, int column) {
        char[][] board = new char[boardSize][boardSize];
        int playerTotal = lastPlayer * boardSize;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = ' ';

        for (int i = 0; i < boardSize; i++) {
            horizontal += board[i][column - 1];
            vertical += board[row - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][boardSize - i - 1];
        }

        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return GameState.WIN;
        }
        return GameState.PLAYING;
    }

    private GameState draw() {
        char[][] board = new char[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                if (board[row][column] == ' ') {
                    return GameState.PLAYING;
                }
            }
        }
        return GameState.DRAW;
    }

    @Override
    public char player() {
        return 'X';
    }

    @Override
    public char nextPlayer() {
        if (player() == 'X') {
            return 'O';
        }
        return 'X';
    }
}
