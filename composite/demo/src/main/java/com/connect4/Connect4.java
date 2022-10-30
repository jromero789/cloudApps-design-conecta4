package com.connect4;

import com.connect4.controllers.AcceptorController;
import com.connect4.controllers.Logic;
import com.connect4.views.View;

public abstract class Connect4 {

	private View view;
	protected Logic logic;

	protected Connect4(){
		this.logic = new Logic();
        this.view = this.createView();
	}

	protected abstract View createView();

	protected void play(){
		AcceptorController acceptorController;
        do {
            acceptorController = logic.getController();
            if (acceptorController != null)
                acceptorController.accept(this.view);
        } while (acceptorController != null);
	}
}

