import controllers.Logic;
import views.graphics.GraphicsView;

public class GraphicsConnect4 extends Connect4{
    
    @Override
	protected GraphicsView createView(Logic logic) {
		return new GraphicsView(logic);
	}

	public static void main(String[] args) {
		new GraphicsConnect4().play();
	}
}
