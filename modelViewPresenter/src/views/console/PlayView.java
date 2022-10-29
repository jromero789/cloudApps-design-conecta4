package views.console;

import controllers.PlayController;
import views.Message;

public class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.isConnect4() && !playController.isDraw());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().getColorChar());
        playController.nextState();
    }
    
}
