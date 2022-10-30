package controllers;

import models.Session;
import types.Color;
import types.Error;

public class ActionController extends Controller  {

    public ActionController(Session session) {
        super(session);
    }

    public boolean isConnect4() {
        return this.session.isConnect4();
    }

    public boolean isDraw() {
        return this.session.isDraw();
    }

    public void next() {
        this.session.next();
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }

    public void putToken(int column) {
        this.session.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.session.getPutTokenError(column);
    }
    
}
