package connect4.views;

import java.util.ArrayList;
import utils.Observer;
import connect4.models.Connect4;
import utils.Command;
import connect4.views.MovementCommand;
import connect4.views.UndoCommand;
import connect4.views.RedoCommand;

class Menu extends utils.Menu {

	Menu(Connect4 connect4, Observer observer) {
		this.commands = new ArrayList<Command>();
		this.commands.add(new MovementCommand(connect4, observer));
		this.commands.add(new UndoCommand(connect4, observer));
		this.commands.add(new RedoCommand(connect4, observer));
	}

}

