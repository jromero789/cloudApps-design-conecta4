package connect4.views;

import utils.YesNoDialog;

public class ResumeView {

	public boolean read() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}
}

