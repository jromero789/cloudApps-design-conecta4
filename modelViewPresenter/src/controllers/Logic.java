package controllers;

import models.Game;
import types.Color;
import types.Error;
import utils.models.Cell;

public class Logic {
    
    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic(Game game) {
        this.game = game;
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public Color getColor(Cell cell) {
        return this.startController.getColor(cell);
    }

    public boolean isConnect4() {
        return this.playController.isConnect4();
    }

    public boolean isDraw() {
        return this.playController.isDraw();
    }

    public void next() {
        this.playController.next();
    }

    public Color getActiveColor() {
        return this.playController.getActiveColor();
    }

    public void putToken(int column) {
        this.playController.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.playController.getPutTokenError(column);
    }

    public void reset() {
        this.resumeController.reset();
    }
    
}
