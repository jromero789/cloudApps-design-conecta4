package connect4.models;

import connect4.types.PlayerType;
import connect4.types.Token;
import connect4.types.Error;
import utils.Coordinate;


public class Player {

	private Token token;
	private Board board;
	private PlayerType type;

	public Player(Token token, Board board, PlayerType type) {
		this.token = token;
		this.board = board;
		this.type = type;
	}

	public PlayerType getType() {
		return this.type;
	}

	void put(Coordinate coordinate) {
		this.board.put(coordinate, this.token);
	};

	Token getToken() {
		return this.token;
	}

	public Error getPutCoordinateError(Coordinate coordinate) {
		// TODO: Implement column logic
		return null;
	}

}
