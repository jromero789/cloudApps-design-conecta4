package utils;

import java.util.Random;

public class Coordinate {

	public static final int DIMENSION = 3;

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
		return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
				&& this.column < Coordinate.DIMENSION;
	}

	public void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(Coordinate.DIMENSION);
		this.column = random.nextInt(Coordinate.DIMENSION);
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