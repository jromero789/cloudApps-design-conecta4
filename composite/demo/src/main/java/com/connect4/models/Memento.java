package com.connect4.models;

public class Memento {

    private Board board;
    private int activePlayer;

    Memento(Board board, Turn turn) {
        try {
            this.board = board.cloneBoard();
            this.activePlayer = turn.getActiveColor().ordinal();
        } catch (Exception e) {
            assert false;
        }
    }

    Board getBoard() {
        return this.board;
    }

    int getActivePlayer() {
        return this.activePlayer;
    }
}
