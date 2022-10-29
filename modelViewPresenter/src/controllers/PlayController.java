package controllers;

import models.Game;
import types.Color;
import types.Error;

public class PlayController  extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public boolean isConnect4() {
        return this.game.isConect4();
    }

    public boolean isDraw() {
        return this.game.isDraw();
    }

    public void next() {
        this.game.next();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public void putToken(int column) {
        this.game.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }
    
}
