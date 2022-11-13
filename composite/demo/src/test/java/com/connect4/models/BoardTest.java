package com.connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.connect4.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {
    
    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    // Check connect4
    @Test
    public void testGivenBoardWhenIsVerticalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "R      ",
                "R      ",
                "R      ",
                "RY     ").build();
        assertThat(board.isConnect4(Color.RED), is(true));
    }

}