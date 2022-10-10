package connect4.views;

import connect4.models.Column;
import utils.WithConsoleView;

class ColumnView extends WithConsoleView {

    Column read(String title) {
        this.console.writeln(title);
        int column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
        return new Column(column);
    }
}
