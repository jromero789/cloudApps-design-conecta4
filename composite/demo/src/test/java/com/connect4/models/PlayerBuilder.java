package com.connect4.models;

import com.connect4.types.Color;

public class PlayerBuilder {
    
    private Color color;
    private String[] rows;

    public PlayerBuilder() {
        this.rows = new String[]{
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       "};
    }

    public PlayerBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public PlayerBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public Player build() {
        Board board = new BoardBuilder().rows(this.rows).build();
        return new Player(this.color, board);
    }
}