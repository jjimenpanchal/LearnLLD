package LearnLLD.LLDPractice.TicTacToe.Models;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private Board board;
    Queue<Player> players;
    Player winner;

    public Game() {
        initializeGame();
    }

    void initializeGame() {
        players = new LinkedList<>();
        board = new Board(3);
        players.add(new Player(1, "Player 1", new PlayingPieceX()));
        players.add(new Player(1, "Player 2", new PlayingPieceO()));
    }

    public boolean runGame() {
        while (winner == null) {
            Player curPlayer = players.poll();
            System.out.println("Player " + curPlayer.name + " turn with symbole " + curPlayer.playingPiece.getSymbolString());
            Move move = curPlayer.decideMove(board);
            curPlayer.makeMove(board, move);

            players.add(curPlayer);
            int result = chechForWinnerOrDraw(board, move, curPlayer.getPlayingPiece());
            if (result == 1) {
                // curPlayer wins
                winner = curPlayer;
                break;
            } else if (result == 2) {
                // match is draw
                break;
            }
        }

        printGameResult();
        return true;
    }

    int chechForWinnerOrDraw(Board board, Move move, PlayingPiece piece) {
        // check for row
        int row = move.row, col = move.col;
        if (board.checkWinner(move, piece)) {
            return 1;
        }
        if (board.isFull()) {
            return 2;
        }
        return 0;
    }


    void printGameResult() {
        if (winner != null) {
            System.out.println("Winner is: " + winner.name);
        } else {
            System.out.println("Match is draw");
        }
    }
}
