import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Coordinate;

public class Board {
    
    private Map<Color, ArrayList<Coordinate>> coordinates;

    Board() {
		this.coordinates = new HashMap<>();
		this.reset();
	}

    void reset() {
        coordinates.values().clear();
    }

    void putToken(int column, Color color){
        // assert !coordinate.isNull();

        // if (coordinates.get(color) == null) {
        //     coordinates.put(color, new ArrayList<Coordinate>());
        //}
        // coordinates.get(color).add(coordinate);

        // this.coordinates.get(color).add(coordinate);
    }

    boolean isConnect4(Color color) {
        // TODO:
        return true;
    }

    boolean isDraw() {
        // TODO:
        return true;
    }

    void write() {
        // TODO: 
    }
}
