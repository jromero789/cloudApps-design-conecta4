package connect4.views;


import connect4.events.MoveEvent;
import connect4.models.Connect4;
import connect4.views.Command;
import utils.Observer;

public class MovementCommand extends Command {

    public MovementCommand(Connect4 connect4, Observer observer) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), connect4, observer);
	}

    @Override
	public void updateIsActive() {
		this.isActive = true;
	}

	@Override
	public void execute() {
		this.notify(new MoveEvent());
	}
    
}
