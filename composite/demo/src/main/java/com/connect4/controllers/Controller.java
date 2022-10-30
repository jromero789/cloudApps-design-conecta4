package com.connect4.controllers;

import com.connect4.models.Session;
import com.utils.models.Cell;
import com.connect4.types.Color;

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
