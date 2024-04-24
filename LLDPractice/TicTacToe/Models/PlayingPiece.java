package LearnLLD.LLDPractice.TicTacToe.Models;

public class PlayingPiece {
    PlayingPieceType symbol;
    PlayingPiece(PlayingPieceType symbol) {
        this.symbol = symbol;
    }

    public String getSymbolString() {
        return symbol.name();
    }
}
