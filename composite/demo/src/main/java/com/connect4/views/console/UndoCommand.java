package com.connect4.views.console;

import com.connect4.controllers.PlayController;
import com.connect4.views.Message;

public class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.undo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.undoable();
	}
	
}
