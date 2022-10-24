import java.util.Map;
import utils.Console;
import java.util.HashMap;

public class Board {
    
    public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    private Map<Cell, Color> cells;
    private Cell lastCell;

    Board() {
		this.cells = new HashMap<>();
        this.lastCell = null;
		this.reset();
	}

    void reset() {
        this.cells = new HashMap<>();
        this.lastCell = null;
    }

    void putToken(int column, Color color){

        int row = 0;
        Cell cell = new Cell(row, column);
        while (row < NUM_ROWS && this.cells.containsKey(cell)){
            cell.moveCell(Direction.VERTICAL_UP, 1);
            row++;
        }
        
        if(!this.cells.containsKey(cell)){
            this.lastCell = cell;
            this.cells.put(this.lastCell, color);
        }
    }

    boolean isColumnFull(int column){
        return this.cells.containsKey(new Cell(NUM_ROWS - 1, column));
    }

    boolean isConnect4(Color color) {
        
        for(Direction direction : Direction.values()){
            for(int displacement = -3; displacement <= 0; displacement++){

                if(isLine(color, direction, displacement)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isLine(Color color, Direction direction, int displacement){

        int i=0;
        while(i<4 && isCellWithSameColor(color, direction, displacement + i))
            i++;

        return i==4;
    }

    private boolean isCellWithSameColor(Color color, Direction direction, int displacement){
        
        Cell referenceCell = this.lastCell.calcReferencedCell(direction, displacement);

        return this.cells.containsKey(referenceCell) && this.cells.get(referenceCell).equals(color);
    }
   
    boolean isDraw() {
        
        int column = 0;
        while (column < NUM_COLUMNS && isColumnFull(column))
            column++;

        return column == NUM_COLUMNS;
    }

    void write() {
        
        Message.HORIZONTAL_LINE.writeln();
		for (int row = NUM_ROWS - 1; row >= 0; row--) {
			Message.VERTICAL_LINE.write();
			for (int column = 0; column < NUM_COLUMNS; column++) {
                Cell cell = new Cell(row, column);
                if(this.cells.containsKey(cell)){
                    Console.getInstance().write(this.cells.get(cell).getColorChar());
                }else{
                    Console.getInstance().write(" ");
                }

				Message.VERTICAL_LINE.write();
			}
			Console.getInstance().writeln();
		}
    }
    
}
