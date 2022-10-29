import controllers.Logic;
import views.console.ConsoleView;


public class ConsoleConnect4 extends Connect4 {
    
    @Override
	protected ConsoleView createView(Logic logic) {
		return new ConsoleView(logic);
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}
}
