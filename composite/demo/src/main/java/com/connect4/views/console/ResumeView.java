package com.connect4.views.console;

import com.connect4.controllers.ResumeController;
import com.utils.views.YesNoDialog;
import com.connect4.views.Message;

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
