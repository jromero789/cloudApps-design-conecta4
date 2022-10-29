package views.console;

import models.Game;
import views.Message;
import views.WithGameView;

public class StartView extends WithGameView{
    
    StartView(Game game){
        super(game);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }
}
