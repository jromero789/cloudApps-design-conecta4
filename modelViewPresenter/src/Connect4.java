import controllers.Logic;
import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;
import models.Game;
import views.View;

public abstract class Connect4 {

	private View view;
	protected Logic logic;

	protected Connect4(){
		this.logic = new Logic(new Game());
        this.view = this.createView(this.logic);
	}

	protected abstract View createView(Logic logic);

	protected void play(){
		do{
			this.view.start();
			this.view.play();
		}while(this.view.resume());
	}
}

