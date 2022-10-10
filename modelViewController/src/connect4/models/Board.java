package connect4.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import connect4.types.Token;

public class Board {
    
	public static final int NUM_ROWS = 6;
    public static final int NUM_COLUMNS = 7;

    private Map<Token, ArrayList<Coordinate>> coordinates;
    private Map<Integer, Integer> columnNumTokens;
	private Map<Coordinate, Token> tokens;

    Board() {
		this.coordinates = new HashMap<>();
        this.columnNumTokens = new HashMap<>();
		this.tokens = new HashMap<>();
		this.reset();
	}

	Board(Map<Token, ArrayList<Coordinate>> coordinates, 
		Map<Integer, Integer> columnNumTokens,
		Map<Coordinate, Token> tokens) {
		this.coordinates = coordinates;
        this.columnNumTokens = columnNumTokens;
		this.tokens = tokens;
		this.reset();
	}

    void reset() {
        coordinates = new HashMap<>();
        coordinates.put(Token.TOKEN_RED, new ArrayList<>());
        coordinates.put(Token.TOKEN_YELLOW, new ArrayList<>());
       
        columnNumTokens = new HashMap<>();
        for(int column = 0; column < NUM_COLUMNS; column++){
            columnNumTokens.put(column, 0);
        }

		tokens = new HashMap<>();
    }

    void putToken(Column column, Token token){

        columnNumTokens.merge(column.getColumn(), 1, Integer::sum);
       
        Coordinate coordinate = new Coordinate(columnNumTokens.get(column.getColumn()) - 1, column.getColumn());
        coordinates.computeIfAbsent(token, k -> new ArrayList<>()).add(coordinate);

		tokens.put(coordinate, token);
    }

    boolean isColumnFull(int column){
        return (this.columnNumTokens.get(column) == NUM_ROWS - 1);
    }

    boolean isConnect4(Token token) {
        
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

	public Token getToken(Coordinate coordinate) {
        return tokens.get(coordinate);
    }

	// ---------------------------
    // static final char EMPTY = '-';
	
	// private Coordinate[][] coordinates;

	// public Board() {
	//	this.coordinates = new Coordinate[Turn.NUM_PLAYERS][Coordinate.DIMENSION];
	//	for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
	//		for (int j = 0; j < Coordinate.DIMENSION; j++) {
	//			this.coordinates[i][j] = null;
	//		}
	//	}
	//}

	// public Board(Coordinate[][] coordinates) {
	//	this.coordinates = coordinates;
	//}

	//public Token getToken(Coordinate coordinate) {
	//	for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
	//		for (int j = 0; j < Coordinate.DIMENSION; j++) {
	//			if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
	//					&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
	//				return Token.values()[i];
	//			}
	//		}
	//	}
	//	return null;
	//}

	// void put(Coordinate coordinate, Token token) {

		// TODO: Implement logic from cloumn
		//int i = 0;
		//assert this.isEmpty(coordinate);
		//while (this.coordinates[token.ordinal()][i] != null) {
		//	i++;
		//}
		//this.coordinates[token.ordinal()][i] = coordinate;
	// }

	//boolean isCompleted() {
	//	for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
	//		for (int j = 0; j < Coordinate.DIMENSION_COLUMN; j++) {
	//			if (this.coordinates[i][j] == null) {
	//				return false;
	//			}
	//		}
	//	}
	//	return true;
	//}


	Board copy() {
		//Coordinate[][] coordinatesCopy = new Coordinate[Turn.NUM_PLAYERS][Coordinate.DIMENSION];
		//for(int i = 0; i < Turn.NUM_PLAYERS; i++ ) {
		//	for(int j = 0; j < Coordinate.DIMENSION; j++ ) {
		//		coordinatesCopy[i][j] = this.coordinates[i][j];
		//	}
		//}
		//return new Board(coordinatesCopy);
		// TODO: Review this. It is not a copy
		return new Board(coordinates, columnNumTokens, tokens);
	}

    
}
