package connect4.views;


import connect4.events.RedoEvent;
import connect4.models.Connect4;
import connect4.views.Command;
import utils.Observer;

public class RedoCommand extends Command {
	
	RedoCommand(Connect4 connect4, Observer observer) {
		super(MessageView.REDO_COMMAND.getMessage(), connect4, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.connect4.redoable();
	}

	@Override
	public void execute() {
		this.notify(new RedoEvent());		
	}

}
