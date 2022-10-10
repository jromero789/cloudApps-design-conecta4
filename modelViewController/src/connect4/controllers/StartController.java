package connect4.controllers;

import connect4.models.Turn;
import connect4.views.StartView;
import utils.PlayersDialog;

class StartController {
    
    int read() {
		new StartView().write();
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		return numberOfUsers;
	}
}
