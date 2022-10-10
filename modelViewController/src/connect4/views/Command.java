package connect4.views;

import connect4.models.Connect4;
import utils.Observer;

abstract class Command extends utils.Command {
	
	protected Connect4 connect4;
	
	protected Command(String title, Connect4 connect4, Observer observer) {
		this.title = title;
		this.connect4 = connect4;
		this.addObserver(observer);
	}

}
