package controllers;

import models.Game;
import models.State;
import utils.models.Cell;
import types.Color;

public abstract class Controller {

    protected Game game;
    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(Cell cell) {
        return this.game.getColor(cell);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);

}
