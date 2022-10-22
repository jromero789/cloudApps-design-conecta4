enum Color {
    RESUME("R"),
	YELLOW("Y");

    private String colorChar;

    private Color(String colorChar) {
        this.colorChar = colorChar;
    }

    public String getColorChar() {
        return colorChar;
    }

   
}
