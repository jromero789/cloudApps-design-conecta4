package views;
import utils.views.Console;

public enum Message {
	TITLE("--- CONNECT4 ---"),
	HORIZONTAL_LINE("---------------"),
	VERTICAL_LINE(" | "),
	ENTER_COLUMN_TO_PUT("Enter a column to put a token:"),
	IS_DRAW("Draw"),
    PLAYER_WIN("#player player: You win!!! :-)"), 
	RESUME("Do you want to continue");
	

	private String message;

	Message(String message) {
		this.message = message;
	}

	public void write() {
		Console.getInstance().write(this.message);
	}

	public void writeln() {
		Console.getInstance().writeln(this.message);
	}

	public void writeln(String player) {
		assert this == Message.PLAYER_WIN;
		
		Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
	}

	@Override
	public String toString() {
		return message;
	}
}
