package connect4.models;

import connect4.events.RedPlayerWinnerEvent;
import connect4.events.YellowPlayerWinnerEvent;
import utils.Observed;

public class Connect4 extends Observed {

    private Game game;
	private Registry registry;
	
	public Connect4(Game game) {
		this.game = game;
		this.registry = new Registry(this.game);
	}
	
	public void createPlayers(int numberOfPlayers) {
		this.game.createPlayers(numberOfPlayers);
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public boolean isConnect4() {
		boolean isConnect4 = this.game.isConnect4();
		if (isConnect4) {
            if (this.game.getValueFromTurn() == 0) {
                this.notify(new RedPlayerWinnerEvent());
            } else {
                this.notify(new YellowPlayerWinnerEvent());
            }
		}
		return isConnect4;
	}
	
	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void registry() {
		this.registry.registry();
	}

	public void newGame() {
		this.game.newGame();
		this.registry.reset();
	}
}
