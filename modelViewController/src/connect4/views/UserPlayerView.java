package connect4.views;

import utils.Coordinate;

public class UserPlayerView {

    public Coordinate readCoordinate(String textToDisplay) {
        Coordinate coordinate = new CoordinateView().read(textToDisplay);
        return coordinate;
    }
}
