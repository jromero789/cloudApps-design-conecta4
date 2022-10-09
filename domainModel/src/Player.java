import utils.Coordinate;
import utils.BoundedIntDialog;

public class Player {
    
    private Color color;
	private Board board;

	Player(Color color, Board board) {
		assert board != null;

		this.color = color;
		this.board = board;
	}

    void play() {
		this.putToken();
	}
    
   private void putToken() {
		int column;
		Error error;
		do {
			column = this.getColumn(Message.ENTER_COLUMN_TO_PUT);
			error = this.getPutTokenError(column);
		} while (!error.isNull());
		this.board.putToken(column, this.color);
	}

    Integer getColumn(Message message){
		assert message != null;
        
		BoundedIntDialog boundedIntDialog = new BoundedIntDialog(0, this.board.NUM_COLUMNS - 1);		 
		return boundedIntDialog.read(Message.ENTER_COLUMN_TO_PUT.toString());
	}

    private Error getPutTokenError(int column) {

		Error error = Error.NULL;
        if (this.board.isColumnFull(column)) {
			error = Error.COLUMN_FULL;
		}
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
