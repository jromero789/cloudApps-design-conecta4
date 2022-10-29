package views.console;

import controllers.StartController;
import views.Message;

public class StartView{

    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.startController);
    }
}
