package com.connect4.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.connect4.types.Color;

public class BoardBuilder {
    

    private List<String> rows;

    public BoardBuilder() {
        this.rows = new ArrayList<>();
    }

    public BoardBuilder rows(String... rows) {
        assert rows.length == 6;
        
        for (String row : rows) {
            assert Pattern.matches("[RY ]{7}", row);
            this.rows.add(row);
        }
        return this;
    }

    public Board build() {
        Board board = new Board();
        if (!this.rows.isEmpty()) {
            for (int i = this.rows.size() - 1; i >= 0; i--) {
                String string = this.rows.get(i);
                for (int j = 0; j < string.length(); j++) {
                    char colorChar = string.charAt(j);
                    if(colorChar == 'R'){
                        board.putToken(j, Color.RED);
                    }else if(colorChar == 'Y'){
                        board.putToken(j, Color.YELLOW);
                    }
                }
            }
        }
        return board;
    }

}
