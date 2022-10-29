package views;

import utils.views.Console;

public class ColumnView {
    
    public static final String COLUMN = "Column: ";

    public int read(String message) {
        assert message != null;

        boolean error;
        int column;
        do {
            Console console = Console.getInstance();
            console.writeln(message);
            column = console.readInt(COLUMN) - 1;

            error = false;
            //column = this.createCoordinate(column);
            //error = !column.isValid();
            // TODO: Handle error
            //if (error) {
            //    Console.getInstance().writeln(this.getErrorMessage());
            //}
        } while (error);
        return column;
    }

}
