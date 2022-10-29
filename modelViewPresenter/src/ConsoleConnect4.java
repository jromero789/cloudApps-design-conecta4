import views.console.ConsoleView;


public class ConsoleConnect4 extends Connect4 {
    
    @Override
	protected ConsoleView createView() {
		return new ConsoleView(this.startController, this.playController, this.resumeController);
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}
}
