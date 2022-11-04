package models;

public class Memento {

    private Board board;
    private int activePlayer;

    Memento(Board board, Turn turn) {
        
        this.board = board.cloneBoard();
        this.activePlayer = turn.getActiveColor().ordinal();
    }

    Board getBoard() {
        return this.board;
    }

    int getActivePlayer() {
        return this.activePlayer;
    }
}
