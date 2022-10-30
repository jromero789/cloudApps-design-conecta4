package com.connect4.controllers;

import com.connect4.models.Session;

public class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }
    
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
