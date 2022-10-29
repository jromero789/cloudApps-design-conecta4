import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;
import models.Game;
import views.View;

public abstract class Connect4 {

    private Game game;
	private View view;
	protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

	protected Connect4(){
		this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView();
	}

	protected abstract View createView();

	protected void play(){
		do{
			this.view.start();
			this.view.play();
		}while(this.view.resume());
	}
}

