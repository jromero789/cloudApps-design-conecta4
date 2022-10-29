package controllers;

import models.Game;
import utils.models.Cell;
import types.Color;

public abstract class Controller {

    protected Game game;

    Controller(Game game) {
        this.game = game;
    }

    public Color getColor(Cell cell) {
        return this.game.getColor(cell);
    }

}
