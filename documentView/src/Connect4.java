import models.Game;
import views.View;

public abstract class Connect4 {

    private Game game;
	private View view;

	protected Connect4(){
		this.game = new Game();
		this.view = this.createView(this.game);
	}

	protected abstract View createView(Game game);

	protected void play(){
		do{
			this.view.start();
			this.view.play();
		}while(this.view.resume());
	}
}

