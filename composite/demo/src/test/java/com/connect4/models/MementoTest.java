package com.connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MementoTest {

    private Memento memento;
    private Board board;
    private Turn turn;

    @BeforeEach
    public void beforeEach() {
        this.board = new BoardBuilder().rows(
            "       ",
            "       ",
            "       ",
            " R     ",
            " Y     ",
            " R     "
        ).build();
        this.turn = new Turn(this.board);
        this.memento = new Memento(this.board, this.turn);
    }

    @Test
    public void testGivenMementoWhenGetActivePlayerThenReturn() {
        assertThat(this.memento.getActivePlayer(), is(0));
    }
}
