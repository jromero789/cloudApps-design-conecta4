package com.connect4.views.console;

import com.connect4.controllers.StartController;
import com.connect4.views.Message;

public class StartView{

    void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }
}
