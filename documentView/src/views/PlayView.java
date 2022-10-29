package views;

import models.Game;

public class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isConect4() && !this.game.isDraw());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().getColorChar());
    }
    
}
