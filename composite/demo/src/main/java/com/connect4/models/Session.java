package com.connect4.models;

import com.connect4.types.Color;
import com.connect4.types.Error;
import com.utils.models.Cell;

public class Session {
    
    private State state;
    private Game game;
    private Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
        this.registry.reset();
    }

    public void nextState() {
        this.state.next();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public void next() {
        this.game.next();
        this.registry.register();
    }

    public Color getColor(Cell cell) {
        return this.game.getColor(cell);
    }

    public boolean isConnect4() {
        return this.game.isConnect4();
    }

    public boolean isDraw() {
        return this.game.isDraw();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }

    public void putToken(int column) {
        this.game.putToken(column);
    }

}
