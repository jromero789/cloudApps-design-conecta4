package connect4.controllers;

import connect4.models.Column;
import connect4.models.Coordinate;
import connect4.models.Game;
import connect4.views.ErrorView;
import connect4.views.GameView;
import connect4.views.UserPlayerView;
import connect4.types.Error;
import connect4.types.PlayerType;

class GameController {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a column to put a token:";

	private GameView gameView;
	private Game game;

	GameController() {
		this.game = new Game();
		this.gameView = new GameView();
	}

	Game getGame() {
		return this.game;
	}

	void doMovement() {
		Error error;
		
		Column column;
		do {
			column = this.readColumnToPut();
			error = this.game.putTokenPlayerFromTurn(column);
			if (error != null && this.isUserPlayerType()) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
	}

	private boolean isUserPlayerType() {
		return this.game.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER;
	}

	private Column readColumnToPut() {
		Column column;
		do {
			column = this.isUserPlayerType()
					? new UserPlayerView().readCoordinate(GameController.ENTER_COORDINATE_TO_PUT)
					: this.generateRandomCoordinate();
			if (!column.isValid() && this.isUserPlayerType()) {
				new ErrorView(Error.WRONG_COORDINATES).writeln();
			}
		} while (!column.isValid());
		return column;
	}

	private Column generateRandomCoordinate() {
		Column columnRandom = new Column();
		columnRandom.random();
		return columnRandom;
	}

	void writeBoard() {
		this.gameView.writeSeparator();
		for (int i = this.game.getCoordinateRowDimension() - 1; i >= 0; i--) {
			this.printRowBoard(i);
        }
        this.gameView.writeSeparator();
	}

	private void printRowBoard(int row) {
        this.gameView.writeVerticalLineLeft();
		for (int j = 0; j < this.game.getCoordinateColumnDimension(); j++) {
			this.printSquareBoard(new Coordinate(row, j));
		}
		this.gameView.writeLineBreak();
	}

	private void printSquareBoard(Coordinate coordinate) {
		if (this.game.isEmptyToken(coordinate)) {
           	this.gameView.writeEmpty();
		} else {
			this.gameView.writeToken(this.game.getTokenChar(coordinate));
        }
        this.gameView.writeVerticalLineCentered();
	}
    
    
}
