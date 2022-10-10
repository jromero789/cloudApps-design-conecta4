package connect4.models;

public class Coordinate {

	protected int row;
	protected int column;

	public Coordinate() {
	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public boolean isValid() {
		return this.row >= 0 && this.row < Board.NUM_ROWS && this.column >= 0
				&& this.column < Board.NUM_COLUMNS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object coordinateObject) {
		if (!(coordinateObject instanceof Coordinate)) {
			return false;
		}
		Coordinate coordinate = (Coordinate) coordinateObject;
		return this.column == coordinate.column && this.row == coordinate.row;
	}
}