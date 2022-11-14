package com.connect4.models;
import com.connect4.types.Color;

public class GameBuilder {

    private String[] rows;
    private Color color;
    private Game game;

    public GameBuilder() {
        this.rows = new String[]{
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       "};
    }

    public GameBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public GameBuilder turn(Color color) {
        this.color = color;
        return this;
    }

    public Game build() {
        this.game = new Game();
        this.buildBoard();
        if (this.color != null && this.game.getActiveColor() != this.color) {
            this.game.next();
        }
        return this.game;
    }

    private void buildBoard() {
        Board board = new BoardBuilder().rows(this.rows).build();
        // TODO: Ask how to set board not changing prod code
    }
    
}
