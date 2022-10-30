package com.connect4.types;

public enum Color {
    RESUME("R"),
	YELLOW("Y"),
    NULL(" ");

    private String colorChar;

    private Color(String colorChar) {
        this.colorChar = colorChar;
    }

    public String getColorChar() {
        return colorChar;
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
}
