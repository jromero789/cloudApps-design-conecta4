package utils;

public class Coordinate {

    protected int row;
	protected int column;

	public Coordinate() {
	}

	protected Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

    public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
}
