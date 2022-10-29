package views;

import controllers.Logic;

public abstract class WithLogicView {

    protected Logic logic;

    protected WithLogicView(Logic logic) {
        this.logic = logic;
    }
    
}
