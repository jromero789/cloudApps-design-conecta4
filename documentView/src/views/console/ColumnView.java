package views.console;

import utils.views.Console;

public class ColumnView {
    
    public static final String COLUMN = "Column: ";

    public int read(String message) {
        assert message != null;

        Console console = Console.getInstance();
        console.writeln(message);
        int column = console.readInt(COLUMN) - 1;
        return column;
    }
}
