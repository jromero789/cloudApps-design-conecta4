package connect4.models;

import connect4.types.Token;
import utils.Coordinate;

public class Board {
    
    static final char EMPTY = '-';

	private Coordinate[][] coordinates;

	public Board() {
		this.coordinates = new Coordinate[Turn.NUM_PLAYERS][Coordinate.DIMENSION];
		for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.coordinates[i][j] = null;
			}
		}
	}

	public Board(Coordinate[][] coordinates) {
		this.coordinates = coordinates;
	}

	public Token getToken(Coordinate coordinate) {
		for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Token.values()[i];
				}
			}
		}
		return null;
	}

	void put(Coordinate coordinate, Token token) {

		// TODO: Implement logic from cloumn
		//int i = 0;
		//assert this.isEmpty(coordinate);
		//while (this.coordinates[token.ordinal()][i] != null) {
		//	i++;
		//}
		//this.coordinates[token.ordinal()][i] = coordinate;
	}

	boolean isConnect4(Token token) {
		
		// TODO: Implement
		return false;
	}

	boolean isCompleted() {
		for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}


	Board copy() {
		Coordinate[][] coordinatesCopy = new Coordinate[Turn.NUM_PLAYERS][Coordinate.DIMENSION];
		for(int i = 0; i < Turn.NUM_PLAYERS; i++ ) {
			for(int j = 0; j < Coordinate.DIMENSION; j++ ) {
				coordinatesCopy[i][j] = this.coordinates[i][j];
			}
		}
		return new Board(coordinatesCopy);
	}
}
