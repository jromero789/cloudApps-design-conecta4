package connect4.views;

import connect4.events.UndoEvent;
import connect4.models.Connect4;
import connect4.views.Command;
import utils.Observer;

public class UndoCommand extends Command {

	UndoCommand(Connect4 connect4, Observer observer) {
		super(MessageView.UNDO_COMMAND.getMessage(), connect4, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.connect4.undoable();
	}

	@Override
	public void execute() {
		this.notify(new UndoEvent());
	}
	
}
