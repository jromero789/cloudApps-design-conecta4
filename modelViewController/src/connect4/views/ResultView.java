package connect4.views;

import utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void write(char winner) {
        this.console.write(winner);
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}
