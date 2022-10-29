package models;
import types.Color;
import types.Error;

public class Player {
    
    private Color color;
	private Board board;

	Player(Color color, Board board) {
		assert board != null;

		this.color = color;
		this.board = board;
	}
    
   	void putToken(int column) {
		this.board.putToken(column, this.color);
	}

	Error getPutTokenError(int column) {
		Error error = Error.NULL;
        if (this.board.isColumnFull(column)) {
			error = Error.COLUMN_FULL;
		}
		return error;
    }

	Color getColor() {
		return this.color;
	}
}
