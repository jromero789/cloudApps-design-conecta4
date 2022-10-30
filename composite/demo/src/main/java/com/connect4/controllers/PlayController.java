package com.connect4.controllers;

import com.connect4.models.Session;
import com.connect4.types.Color;
import com.connect4.types.Error;

public class PlayController extends Controller implements AcceptorController {
    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public void undo(){
        this.undoController.undo();
    }

    public boolean undoable(){
        return this.undoController.undoable();
    }

    public void redo(){
        this.redoController.redo();
    }

    public boolean redoable(){
        return this.redoController.redoable();
    }

    public boolean isConnect4() {
        return this.actionController.isConnect4();
    }

    public boolean isDraw() {
        return this.actionController.isDraw();
    }

    public void next() {
        this.actionController.next();
    }

    public Color getActiveColor() {
        return this.actionController.getActiveColor();
    }

    public void putToken(int column) {
        this.actionController.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.actionController.getPutTokenError(column);
    }
    
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
