package views.console;

import controllers.StartController;
import views.Message;

public class StartView{

    void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }
}
