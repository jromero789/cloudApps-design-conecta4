package views.console;

import controllers.PlayController;

public abstract class Command extends utils.models.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}

	@Override
	public void execute() {
		new BoardView().write(this.playController);
	}
	
}
