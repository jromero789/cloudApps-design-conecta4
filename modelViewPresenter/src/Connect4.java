import controllers.Controller;
import controllers.Logic;
import views.View;

public abstract class Connect4 {

	private View view;
	protected Logic logic;

	protected Connect4(){
		this.logic = new Logic();
        this.view = this.createView();
	}

	protected abstract View createView();

	protected void play(){
		Controller controller;
		do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.view);
        } while (controller != null);
	}
}

