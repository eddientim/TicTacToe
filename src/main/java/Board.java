import exceptions.BoxOccupiedException;
import exceptions.PieceOutOfBoundsException;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private final int row;
    private final int column;
    private final int boardSize;
    private int occupiedBoxes;
    Set<String> validCells = new HashSet<>();

    public Board(int row, int column, int boardSize) {
        this.row = row;
        this.column = column;
        this.boardSize = boardSize;
    }

    public void pieceOutOfBounds() {
        if ((row > boardSize) || (column > boardSize)) {
            throw new PieceOutOfBoundsException("Piece is outside board");
        }
    }

    public boolean markBox(char playerMark) {
        char[][] board = new char[boardSize][boardSize];

        if (board[row][column] != '\0') {
            throw new BoxOccupiedException("Box already occupied.");
        } else {
            board[row][column] = playerMark;
            occupiedBoxes++;
        }
        return true;
    }

    private void initialBoard(char[][] board) {
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                board[row][column] = ' ';
                validCells.add(row + "" + column);
            }
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "x=" + row +
                ", y=" + column +
                ", boardSize=" + boardSize +
                ", occupiedBoxes=" + occupiedBoxes +
                '}';
    }
}
