package views;

import controllers.Logic;

public abstract class View extends WithLogicView {

    protected View(Logic logic) {
        super(logic);
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();
}
