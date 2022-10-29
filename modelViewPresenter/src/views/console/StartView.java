package views.console;

import controllers.Logic;
import views.Message;
import views.WithLogicView;

public class StartView extends WithLogicView{

    StartView(Logic logic) {
        super(logic);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.logic);
    }
}
