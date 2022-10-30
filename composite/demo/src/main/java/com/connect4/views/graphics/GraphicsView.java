package com.connect4.views.graphics;

import com.connect4.controllers.PlayController;
import com.connect4.controllers.ResumeController;
import com.connect4.controllers.StartController;
import com.connect4.views.View;

public class GraphicsView implements View {

    public void visit(StartController startController) {
    }

    public void visit(PlayController playController) {
    }

    public boolean visit(ResumeController resumeController) {
        return true;
    }
}