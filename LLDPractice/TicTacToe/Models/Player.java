package LearnLLD.LLDPractice.TicTacToe.Models;

import java.util.Scanner;

public class Player {
    int id;
    String name;
    PlayingPiece playingPiece;
    Scanner scanner = new Scanner(System.in);

    Player(int id, String name, PlayingPiece playingPiece) {
        this.id = id;
        this.name = name;
        this.playingPiece = playingPiece;
    }

    Move decideMove(Board board) {
        board.printBoard();
        System.out.println("pls Enter 0 indexed row and col number to place your piece");
        int row = 0, col = 0;

        row = scanner.nextInt();
        col = scanner.nextInt();

        Move move = new Move(row, col);
        return move;
    }

    boolean makeMove(Board board, Move move) {
        return board.placePiece(playingPiece, move);
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

}
