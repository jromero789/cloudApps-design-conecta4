package views.console;

import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;
import views.View;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(StartController startController, PlayController playController, ResumeController resumeController) {
        super(startController,playController,resumeController);
        this.startView = new StartView(this.startController);
        this.playView = new PlayView(this.playController);
        this.resumeView = new ResumeView(this.resumeController);
    }

    @Override
    public void start() {
        this.startView.interact();
    }

    @Override
    public void play() {
        this.playView.interact();
    }

    @Override
    public boolean resume() {
        return this.resumeView.interact();
    }
    
}
