package connect4.views;

import utils.WithConsoleView;

class BoardView extends WithConsoleView {

    void write(char token) {
        this.console.write(token);
    }

    void writeln() {
        this.console.writeln();
    }
    
}
