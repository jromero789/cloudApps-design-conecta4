package views.console;

import controllers.ResumeController;
import utils.views.YesNoDialog;
import views.Message;

public class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }
}
