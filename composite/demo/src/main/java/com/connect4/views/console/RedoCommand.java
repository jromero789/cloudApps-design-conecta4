package com.connect4.views.console;

import com.connect4.controllers.PlayController;
import com.connect4.views.Message;

public class RedoCommand  extends Command {
	
	RedoCommand(PlayController playController) {
		super(Message.REDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.redo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.redoable();
	}
}
