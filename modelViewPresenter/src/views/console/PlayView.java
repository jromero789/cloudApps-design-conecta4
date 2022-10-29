package views.console;

import controllers.PlayController;
import views.Message;

public class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            new PlayerView(this.playController).interact();
            this.playController.next();
            new BoardView().write(this.playController);
        } while (!this.playController.isConnect4() && !this.playController.isDraw());
        Message.PLAYER_WIN.writeln(this.playController.getActiveColor().getColorChar());
    }
    
}
