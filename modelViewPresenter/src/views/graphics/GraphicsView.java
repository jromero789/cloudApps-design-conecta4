package views.graphics;

import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;
import views.View;

public class GraphicsView implements View {

    public void visit(StartController startController) {
    }

    public void visit(PlayController playController) {
    }

    public boolean visit(ResumeController resumeController) {
        return true;
    }
}