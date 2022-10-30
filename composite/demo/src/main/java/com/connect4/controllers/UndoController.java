package com.connect4.controllers;

import com.connect4.models.Session;

public class UndoController  extends Controller {

    UndoController(Session session) {
        super(session);
    }

    void undo() {
        this.session.undo();
    }

    boolean undoable() {
        return this.session.undoable();
    }

}
