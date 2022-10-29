package views;

import utils.models.Cell;
import utils.views.Console;

public class ColumnView {
    
    public int read(String message) {
        assert message != null;

        boolean error;
        int column;
        do {
            Console console = Console.getInstance();
            console.writeln(message);
            column = console.readInt(Cell.COLUMN) - 1;

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
