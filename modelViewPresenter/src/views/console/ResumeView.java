package views.console;

import controllers.Logic;
import utils.views.YesNoDialog;
import views.Message;
import views.WithLogicView;

public class ResumeView  extends WithLogicView {

    ResumeView(Logic logic) {
        super(logic);
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.reset();
        }
        return isResumed.isAffirmative();
    }
}
