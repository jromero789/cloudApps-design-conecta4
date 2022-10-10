package connect4.views;

import connect4.events.NewGameEvent;
import connect4.events.RedPlayerWinnerEvent;
import connect4.events.YellowPlayerWinnerEvent;
import connect4.models.Connect4;
import connect4.types.Token;
import utils.Event;
import utils.Observed;
import utils.Observer;
import utils.YesNoDialog;

public class Connect4View extends Observed implements Observer {

    private Connect4 connect4;

	private Menu menu;

	public Connect4View(Connect4 connect4, Observer observer) {
		this.connect4 = connect4;
		this.menu = new Menu(connect4, observer);
	}

	public void write() {
		new StartView().write();
		do {
			this.menu.execute();
		} while (!this.connect4.isConnect4());
	}

	public void update(final Observed observed, final Event event) {
		if (event instanceof RedPlayerWinnerEvent) {
			new ResultView().write(Token.TOKEN_RED.getChar());
			this.resume();
		} else if (event instanceof YellowPlayerWinnerEvent) {
			new ResultView().write(Token.TOKEN_YELLOW.getChar());
			this.resume();
		}
	}

	private void resume() {
		if (new YesNoDialog().read(MessageView.RESUME.getMessage())) {
			this.notify(new NewGameEvent());
		}
	}
    
}
