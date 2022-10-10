package connect4.views;

import connect4.models.Column;

public class UserPlayerView {

    public Column readCoordinate(String textToDisplay) {
        Column coordinate = new ColumnView().read(textToDisplay);
        return coordinate;
    }
}
