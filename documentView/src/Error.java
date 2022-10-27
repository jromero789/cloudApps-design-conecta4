import utils.Console;

enum Error {
	COLUMN_INVALID("The column is invalid"),
	COLUMN_FULL("The column is full"),
	NULL;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	void writeln() {
		if (!this.isNull()) {
			Console.getInstance().writeln(this.message);
		}
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

}
