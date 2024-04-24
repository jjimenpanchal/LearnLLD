package LearnLLD.LLDPractice.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<PlayingPiece>> board;

    Board(int size) {
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<PlayingPiece> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(null);
            }
            board.add(row);
        }
    }

    boolean placePiece(PlayingPiece piece, Move move) {
        int row = move.row, col = move.col;

        if (board.get(row).get(col) == null) {
            board.get(row).set(col, piece);
            return true;
        }
        return false;
    }

    void printBoard() {
        for (List<PlayingPiece> row : board) {
            for (PlayingPiece piece : row) {
                if (piece == null) {
                    System.out.print("   |");
                } else {
                    System.out.print(" " + piece.getSymbolString() + " |");
                }
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (List<PlayingPiece> row : board) {
            for (PlayingPiece piece : row) {
                if (piece == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner(Move move, PlayingPiece piece) {
        int row = move.row, col = move.col;
        // check for row
        boolean isWinner = true;
        for (int i = 0; i < board.size(); i++) {
            if (board.get(row).get(i) != piece) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            return true;
        }

        // check for col
        isWinner = true;
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(col) != piece) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            return true;
        }

        // check for diagonal
        isWinner = true;
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(i) != piece) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            return true;
        }

        // check for anti-diagonal
        isWinner = true;
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(board.size() - i - 1) != piece) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            return true;
        }

        return false;
    }
}
