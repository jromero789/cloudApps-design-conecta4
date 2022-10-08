import utils.Coordinate;

public class Player {
    
    private Color color;
	private Board board;
	// private int putTokens;

	Player(Color color, Board board) {
		// assert !color.isNull();
		assert board != null;

		this.color = color;
		this.board = board;
		// this.putTokens = 0;
	}

    void play() {
		this.putToken();
	}
    
   private void putToken() {
        // TODO: Instead of insert coordinate, 
        // user selects the column and coordinate is calculated
		int column;
		Error error;
		do {
			column = this.getColumn(Message.ENTER_COLUMN_TO_PUT);
			error = this.getPutTokenError(column);
		} while (!error.isNull());
		this.board.putToken(column, this.color);
		// this.putTokens++;
	}

    Integer getColumn(Message message){
		assert message != null;
        
        
	    // Coordinate coordinate = new Coordinate();
		// coordinate.read(message.toString());
		// return coordinate;
        // TODO: 
        return 1;
	}

    private Error getPutTokenError(int column) {

		Error error = Error.NULL;
		// TODO: Check cloumn is ok and not full
        //if (!this.board.isEmpty(coordinate)) {
		//	error = Error.NOT_EMPTY;
		//}
		error.writeln();
		return error;
	}

    void writeWinner() {
		Message.PLAYER_WIN.writeln(this.color.name());
	}

	Color getColor() {
		return this.color;
	}
}
