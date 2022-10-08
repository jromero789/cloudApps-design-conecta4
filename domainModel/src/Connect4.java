import utils.YesNoDialog;

public class Connect4 {

    private Board board;
    private Turn turn;

    Connect4(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play(){
        do{
            this.playGame();
        }while(this.isResumedGame());
    }

    private void playGame() {
		Message.TITLE.writeln();
		this.board.write();
		do {
			this.turn.play();
			this.board.write();
		} while (!this.isConect4() && !this.isDraw());
		// this.turn.writeWinner();
	}

    private boolean isConect4() {
		//	return this.board.isTicTacToe(this.turn.getActiveColor());
		return true;
	}
	
	private boolean isDraw() {
		//	return this.board.isTicTacToe(this.turn.getActiveColor());
		return true;
	}

	private void writeResult(){
		if(this.isConect4()){
			this.turn.writeWinner();
		}
		if(this.isDraw()){
			// TODO:
		}
	}

    private boolean isResumedGame() {
		YesNoDialog yesNoDialog = new YesNoDialog();
		yesNoDialog.read(Message.RESUME.toString());
		if (yesNoDialog.isAffirmative()) {
			this.board.reset();
			this.turn.reset();
		}
		return yesNoDialog.isAffirmative();
	}

    public static void main(String[] args) {
        new Connect4().play();
    }
}
