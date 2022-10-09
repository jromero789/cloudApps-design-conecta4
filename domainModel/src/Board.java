import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Coordinate;

public class Board {
    
    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    private Map<Color, ArrayList<Coordinate>> coordinates;
    private Map<Integer, Integer> columnNumTokens;

    Board() {
		this.coordinates = new HashMap<>();
        this.columnNumTokens = new HashMap<>();
		this.reset();
	}

    void reset() {
        coordinates = new HashMap<>();
        coordinates.put(Color.RED, new ArrayList<>());
        coordinates.put(Color.YELLOW, new ArrayList<>());
       
        columnNumTokens = new HashMap<>();
        for(int column = 0; column < NUM_COLUMNS; column++){
            columnNumTokens.put(column, 0);
        }
    }

    void putToken(int column, Color color){

        columnNumTokens.merge(column, 1, Integer::sum);
       
        Coordinate coordinate = new Coordinate(columnNumTokens.get(column), column);
        coordinates.computeIfAbsent(color, k -> new ArrayList<>()).add(coordinate);
    }

    boolean isColumnFull(int column){
        return (this.columnNumTokens.get(column) == NUM_ROWS - 1);
    }

    boolean isConnect4(Color color) {
        
        // TODO: Check connect4 for that color
        return false;
    }

    boolean isDraw() {
        
        for(Integer maxRow : this.columnNumTokens.values()){
            if (maxRow < NUM_ROWS - 1){
                return false;
            }
        }
        return true;
    }

    void write() {
        // TODO: Show board
    }
}
