package connect4.views;

import utils.WithConsoleView;

public class StartView extends WithConsoleView {

    public void write() {
		this.console.writeln(MessageView.START_GAME.getMessage());
	}
}
