public class Cell {
    
    private int row;
    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Cell calcReferencedCell(Direction direction, int displacement){

        int referenceRow = this.row + direction.directionRow * displacement;
        int referenceColumn = this.column + direction.directionColumn * displacement;
        
        return new Cell(referenceRow, referenceColumn);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + row;
        result = prime * result + column;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (row != other.row)
            return false;
        if (column != other.column)
            return false;
        return true;
    }
}
