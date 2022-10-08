import java.util.ArrayList;
import java.util.List;

public class Turn {
    
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private List<Player> players;
    private int activePlayer;

    Turn(Board board) {
		assert board != null;
		this.board = board;
        this.players = new ArrayList<>();
		this.reset();
	}

    void reset() {
        // TODO: Create players & set active player
    }

    void play() {
        this.players.get(this.activePlayer).play();
		if (!this.board.isConnect4(this.getActiveColor()) || this.board.isDraw()){
			this.activePlayer = (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
		}
    }

    void writeWinner(){
        this.players.get(this.activePlayer).writeWinner();
    }

    Color getActiveColor() {
		return this.players.get(this.activePlayer).getColor();
	}
}
