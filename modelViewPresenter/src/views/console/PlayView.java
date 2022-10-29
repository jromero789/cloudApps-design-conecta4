package views.console;

import controllers.Logic;
import views.Message;
import views.WithLogicView;

public class PlayView extends WithLogicView {

    PlayView(Logic logic) {
        super(logic);
    }

    void interact() {
        do {
            new PlayerView(this.logic).interact();
            this.logic.next();
            new BoardView().write(this.logic);
        } while (!this.logic.isConnect4() && !this.logic.isDraw());
        Message.PLAYER_WIN.writeln(this.logic.getActiveColor().getColorChar());
    }
    
}
