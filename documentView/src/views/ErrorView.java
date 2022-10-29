package views;

import java.util.Map;
import types.Error;
import utils.views.Console;

public class ErrorView {

    private static final Map<Error, String> errorMessage = Map.of(
        Error.COLUMN_INVALID, "The column is invalid",
        Error.COLUMN_FULL, "The column is full",
        Error.NULL, ""
    );

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.errorMessage.get(error));
   
        }
    }
}
