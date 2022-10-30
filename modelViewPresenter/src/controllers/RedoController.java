package controllers;

import models.Session;

public class RedoController extends Controller {

    RedoController(Session session) {
        super(session);
    }

    void redo() {
        this.session.redo();
    }

    boolean redoable() {
        return this.session.redoable();
    }
    
}
