package com.connect4.models;

import com.utils.models.Cell;
import com.connect4.types.Color;
import com.connect4.types.Error;

public class Game {

    private Board board;
    private Turn turn;

    public Game(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

	public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    Memento createMemento() {
        return new Memento(this.board, this.turn);
    }

    void setMemento(Memento memento) {
        this.board = memento.getBoard();
        this.turn = new Turn(this.board);
        this.turn.setActivePlayer(memento.getActivePlayer());
    }

	public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnect4() {
		return this.board.isConnect4(this.turn.getActiveColor());
	}
	
	public boolean isDraw() {
		return this.board.isDraw();
	}

    public Color getColor(Cell cell) {
        return this.board.getColor(cell);
    }

    public void putToken(int column) {
        this.turn.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }
}
