package connect4.controllers;

import connect4.events.MoveEvent;
import connect4.events.NewGameEvent;
import connect4.events.RedoEvent;
import connect4.events.UndoEvent;
import connect4.models.Connect4;
import connect4.views.Connect4View;
import utils.Event;
import utils.Observed;
import utils.Observer;

class Connect4Controller implements Observer{
    
    private GameController gameController;
	private Connect4 connect4;
	private Connect4View connect4View;
	
	Connect4Controller() {
		this.clear();
	}
	
	void clear() {
		this.gameController = new GameController();
		this.connect4 = new Connect4(this.gameController.getGame());
		this.connect4View = new Connect4View(this.connect4, this);
		this.connect4View.addObserver(this);
		this.connect4.addObserver(this.connect4View);	
	}
	
	void play() {
        int numberOfUsers = new StartController().read();
        this.connect4.createPlayers(numberOfUsers);
		this.gameController.writeBoard();
		this.connect4.registry();
		this.connect4View.write();
	}

	
	public void update(Observed observed, Event event) {
		if (event instanceof MoveEvent) {
			this.gameController.doMovement();
            this.connect4.registry();
            this.gameController.writeBoard();
		} else if (event instanceof UndoEvent) {
            this.connect4.undo();
            this.gameController.writeBoard();			
		} else if (event instanceof RedoEvent) {
            this.connect4.redo();
            this.gameController.writeBoard();
		} else if (event instanceof NewGameEvent) {
			this.clear();
			this.connect4.newGame();
			this.play();
		}
	}

	public static void main(String[] args) {
		new Connect4Controller().play();
	}

}
