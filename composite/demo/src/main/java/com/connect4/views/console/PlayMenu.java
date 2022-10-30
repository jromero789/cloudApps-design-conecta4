package com.connect4.views.console;

import com.connect4.controllers.PlayController;
import com.utils.views.Menu;

public class PlayMenu extends Menu {

    PlayMenu(PlayController playController) {
        this.addCommand(new ActionCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }

}