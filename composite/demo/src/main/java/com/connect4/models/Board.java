package com.connect4.models;
import java.util.Map;
import com.connect4.types.Color;
import com.utils.models.Cell;
import com.utils.models.Direction;
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

    private Board(Map<Cell, Color> cells, Cell lastCell) {
		this.cells = cells;
        this.lastCell = lastCell;
	}

    Board cloneBoard(){
        Map<Cell, Color> cellsCopy = new HashMap<>();
        for (Map.Entry<Cell, Color> entry : this.cells.entrySet()) {
            Cell cell = entry.getKey().cloneCell();
            Color color = entry.getValue();
            
            cellsCopy.put(cell, color);
        }
        Cell lastCellCopy = null;
        if(this.lastCell != null){
            lastCellCopy = this.lastCell.cloneCell();
        }
        return new Board(cellsCopy, lastCellCopy);
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
        
        if (this.lastCell == null){
            return false;
        }

        Cell referenceCell = this.lastCell.calcReferencedCell(direction, displacement);

        return this.cells.containsKey(referenceCell) && this.cells.get(referenceCell).equals(color);
    }
   
    boolean isDraw() {
        
        int column = 0;
        while (column < NUM_COLUMNS && isColumnFull(column))
            column++;

        return column == NUM_COLUMNS;
    }

    Color getColor(Cell cell) {

        if(this.cells.containsKey(cell)){
            return this.cells.get(cell);
        }else{
            return Color.NULL;
        }
    }
    
}
