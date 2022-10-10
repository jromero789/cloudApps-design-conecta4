package connect4.types;

public enum Token {

	TOKEN_YELLOW('Y'),
	TOKEN_RED('R');

	private char character;

	Token(char character){
		this.character = character;
	}

	public char getChar() {
		return this.character;
	}

}
