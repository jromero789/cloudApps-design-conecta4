package controllers;

import models.Session;
import utils.models.Cell;
import types.Color;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session= session;
    }

    public void nextState() {
        this.session.nextState();
    }

    public Color getColor(Cell cell) {
        return this.session.getColor(cell);
    }
    
}
