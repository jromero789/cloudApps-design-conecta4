package com.connect4.views;

import java.util.Map;
import com.connect4.types.Error;
import com.utils.views.Console;

public class ErrorView {

    private static final Map<Error, String> errorMessage = Map.of(
        Error.COLUMN_INVALID, "The column is invalid",
        Error.COLUMN_FULL, "The column is full",
        Error.NULL, ""
    );

    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.errorMessage.get(error));
   
        }
    }
}
