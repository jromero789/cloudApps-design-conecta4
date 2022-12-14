package com.connect4.views.console;

import com.connect4.types.Error;
import com.connect4.views.ErrorView;
import com.connect4.views.Message;
import com.connect4.controllers.PlayController;

public class PlayerView {

    private PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
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
        this.playController.putToken(column);
    }

    int getColumn(Message message) {
        assert message != null;

        return new ColumnView().read(message.toString());
    }

    private Error getPutTokenError(int column) {
        Error error = this.playController.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }
}
