package views.console;

import controllers.Logic;
import models.Board;
import utils.models.Cell;
import utils.views.Console;
import views.Message;

public class BoardView {
    
    void write(Logic logic){
        Message.HORIZONTAL_LINE.writeln();
		for (int row = Board.NUM_ROWS - 1; row >= 0; row--) {
			Message.VERTICAL_LINE.write();
			for (int column = 0; column < Board.NUM_COLUMNS; column++) {
                new ColorView().write(logic.getColor(new Cell(row, column)));
				Message.VERTICAL_LINE.write();
			}
            Console.getInstance().writeln();
		}
        Message.HORIZONTAL_LINE.writeln();
    }
}
