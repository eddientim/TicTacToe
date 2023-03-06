import exceptions.BoxOccupiedException;
import exceptions.PieceOutOfBoundsException;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private final int boardSize = 3;
    private int occupiedBoxes;

    private char[][] board = new char[boardSize][boardSize];
    private Set<String> validCells = new HashSet<>();

    public Board() {
        for (int row = 0; row < this.boardSize; row++) {
            for (int column = 0; column < this.boardSize; column++) {
                board[row][column] = ' ';
                validCells.add(row+""+column);
            }
        }
    }

    public boolean markBox(char playerMark, int row, int column) {
        pieceOutOfBounds(row, column);

        if (board[row][column] != ' ') {
            throw new BoxOccupiedException("Box already occupied.");
        } else {
            board[row][column] = playerMark;
            occupiedBoxes++;
        }
        return true;
    }

    private void pieceOutOfBounds(int row, int column) {
        if ((row < 0 || row > boardSize) || (column < 0 || column > boardSize)) {
            throw new PieceOutOfBoundsException("Piece is outside board");
        }
    }

    public boolean hasWinner() {
        return (checkRowsForWinner() || checkColumnsForWinner() || checkDiagonalsForWinner());
    }

    private boolean checkDiagonalsForWinner() {
        return checkFirstDiagonal() || checkSecondDiagonal();
    }

    private boolean checkFirstDiagonal() {
        char cell1 = board[0][0];
        int rowColumn = 1;
        while (rowColumn < boardSize) {
            if (cell1 == ' ' || cell1 != board[rowColumn][rowColumn]) {
                return false;
            }
            rowColumn++;
        }
        return true;
    }

    private boolean checkSecondDiagonal() {
        char cell1 = board[0][2];
        int row = 1;
        int column = 1;
        while (row < boardSize) {
            if (cell1 == ' ' || cell1 != board[row][column]) {
                return false;
            }
            row++;
            column--;
        }
        return true;
    }

    private boolean checkRowsForWinner() {
        for (int row = 0; row < boardSize; row++) {
            if (checkRow(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWinner() {
        for (int column = 0; column < boardSize; column++) {
            if (checkColumn(column)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row) {
        char cell1 = board[row][0];
        int column = 1;
        while (column < boardSize) {
            if (cell1 == ' ' || cell1 != board[row][column]) {
                return false;
            }
            column++;
        }
        return true;
    }

    private boolean checkColumn(int column) {
        char cell1 = board[0][column];
        int row = 1;
        while (row < boardSize) {
            if (cell1 == ' ' || cell1 != board[row][column]) {
                return false;
            }
            row++;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Board{" +
                ", boardSize=" + boardSize +
                ", occupiedBoxes=" + occupiedBoxes +
                '}';
    }
}
