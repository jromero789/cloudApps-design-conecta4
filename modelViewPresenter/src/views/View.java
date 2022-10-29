package views;

import controllers.Logic;
import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;

public abstract class View extends WithLogicView {

    public View(Logic logic) {
        super(logic);
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();
}
