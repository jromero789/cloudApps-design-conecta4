package types;

public enum Error {
	COLUMN_INVALID,
	COLUMN_FULL,
	NULL;

	public boolean isNull() {
		return this == Error.NULL;
	}
}
