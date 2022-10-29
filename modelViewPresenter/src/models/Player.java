package models;
import types.Color;
import types.Error;
import utils.models.ClosedInterval;

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
		ClosedInterval closedInterval = new ClosedInterval(0, Board.NUM_COLUMNS);
        if (this.board.isColumnFull(column)) {
			error = Error.COLUMN_FULL;
		}else if(!closedInterval.isIncluded(column)){
			error = Error.COLUMN_INVALID;
		}

		return error;
    }

	Color getColor() {
		return this.color;
	}
}
