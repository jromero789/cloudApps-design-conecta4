import models.Game;
import views.console.ConsoleView;


public class ConsoleConnect4 extends Connect4 {
    
    @Override
	protected ConsoleView createView(Game game) {
		return new ConsoleView(game);
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}
}
