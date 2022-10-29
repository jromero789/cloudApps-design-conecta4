package views.console;

import types.Error;
import views.ErrorView;
import views.Message;
import views.WithLogicView;
import controllers.Logic;

public class PlayerView extends WithLogicView {

    PlayerView(Logic logic) {
        super(logic);
    }
    
    void interact() {
        this.putToken();
    }

    private void putToken() {
        int column;
        Error error;
        do {
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT);
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.logic.putToken(column);
    }

    int getColumn(Message message) {
        assert message != null;

        return new ColumnView().read(message.toString());
    }

    private Error getPutTokenError(int column) {
        Error error = this.logic.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }
}
