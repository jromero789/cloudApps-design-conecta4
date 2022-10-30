package com.connect4.views;

import com.utils.views.Console;

public enum Message {
	TITLE("--- CONNECT4 ---"),
	HORIZONTAL_LINE("---------------"),
	VERTICAL_LINE(" | "),
	ENTER_COLUMN_TO_PUT("Enter a column to put a token:"),
	IS_DRAW("Draw"),
    PLAYER_WIN("#player player: You win!!! :-)"), 
	RESUME("Do you want to continue"),
	ACTION_COMMAND("Do a action"),
    UNDO_COMMAND("Undo previous action"),
    REDO_COMMAND("Redo previous action");
	

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
