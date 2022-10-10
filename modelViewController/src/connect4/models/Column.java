package connect4.models;

import java.util.Random;

public class Column {
    
	protected int column;

	public Column() {
	}

	public Column(int column) {
		this.column = column;
	}

	public int getColumn() {
		return this.column;
	}

	public boolean isValid() {
		return this.column >= 0 && this.column < Board.NUM_COLUMNS;
	}

	public void random() {
		Random random = new Random(System.currentTimeMillis());
		this.column = random.nextInt(Board.NUM_COLUMNS);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		return result;
	}

	@Override
	public boolean equals(Object coordinateObject) {
		if (!(coordinateObject instanceof Coordinate)) {
			return false;
		}
		Coordinate coordinate = (Coordinate) coordinateObject;
		return this.column == coordinate.column;
	}
}
