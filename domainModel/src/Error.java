import utils.Console;

enum Error {
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
