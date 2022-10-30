package com.connect4.views.console;

import com.connect4.controllers.PlayController;
import com.connect4.views.Message;

public class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } while (!playController.isConnect4() && !playController.isDraw());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().getColorChar());
        playController.nextState();
    }
    
}
