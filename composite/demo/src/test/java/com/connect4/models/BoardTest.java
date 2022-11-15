package com.connect4.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.connect4.types.Color;
import com.utils.models.Cell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BoardTest {
    
    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }


    // Is empty

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty() {
        Board board = this.boardBuilder.build();
        assertEmpty(board);
    }

    private static void assertEmpty(Board board) {
        for (int i = 0; i < Board.NUM_ROWS; i++) {
            for (int j = 0; j < Board.NUM_COLUMNS; j++) {
                assertThat(board.getColor(new Cell(i, j)), is(Color.NULL));
            }
        }
    }

    @Test
    public void testGivenExampleBoardWhenResetThenIsEmpty() {
        Board board = getExamplBoard();
        board.reset();
        assertEmpty(board);
    }

    // Put token

    @Test
    public void testGivenBoardWhenPutTokenThenReturnColor() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                " R     ",
                " RY    ",
                "YRY    ").build();
        board.putToken(2, Color.RED);
        assertThat(board.getColor(new Cell(2, 2)), is(Color.RED));
    }

    // Is column full

    @Test
    public void testGivenEmptyBoardWhenPutTokenThenReturnColumnIsNotFull() {
        Board board = this.boardBuilder.build();
        assertThat(board.isColumnFull(3), is(false));
    }

    @Test
    public void testGivenExampleBoardWhenPutTokenThenReturnColumnIsNotFull() {
        Board board = getExamplBoard();
        assertThat(board.isColumnFull(3), is(false));
    }

    @Test
    public void testGivenBoardWhenColumnFullPutTokenThenReturnColumnIsFull() {
        Board board = this.boardBuilder.rows(
                " Y     ",
                " R     ",
                " Y     ",
                " R     ",
                " RY    ",
                "YRY    ").build();
        assertThat(board.isColumnFull(1), is(true));
    }

    // Get color

    @Test
    public void testGivenEmptyBoardWhenCheckGetColorFromEmptyThenReturnColorNull() {
        Board board = this.boardBuilder.build();
        assertThat(board.getColor(new Cell(2, 4)), is(Color.NULL));
    }

    @Test
    public void testGivenExampleBoardWhenCheckGetColorFromEmptyThenReturnColorNull() {
        Board board = getExamplBoard();
        assertThat(board.getColor(new Cell(2, 4)), is(Color.NULL));
    }

    @Test
    public void testGivenBoardWhenCheckGetColorThenReturn() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                " R     ",
                " RY    ",
                "YRY    ").build();
        assertThat(board.getColor(new Cell(0, 1)), is(Color.RED));
    }

    // Check is connect4

    @Test
    public void testGivenEmptyBoardWhenIsConnect4ThenIsFalse() {
        Board board = this.boardBuilder.build();
        assertThat(board.isConnect4(Color.RED), is(false));
    }

    @Test
    public void testGivenExampleBoardWhenIsConnect4ThenIsFalse() {
        Board board = getExamplBoard();
        assertThat(board.isConnect4(Color.RED), is(false));
    }

    @Test
    public void testGivenBoardWhenIsConnect4NullColorThenAssertionError() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isConnect4(Color.NULL));
    }

    @Test
    public void testGivenBoardWhenIsVerticalConncect4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                " R     ",
                " RY    ",
                "YRY    ").build();
        board.putToken(1, Color.RED);
        assertThat(board.isConnect4(Color.RED), is(true));
    }

    @Test
    public void testGivenBoardWhenIsHorizontalConncect4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                " R     ",
                " RYYY  ",
                "YRYRRR ").build();
        board.putToken(5, Color.YELLOW);
        assertThat(board.isConnect4(Color.YELLOW), is(true));
    }

    @Test
    public void testGivenBoardWhenIsDiagonalConncect4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                " YYRRR ",
                " RYRYY ",
                " YRYYR ",
                "YRYRRRY").build();
        board.putToken(5, Color.RED);
        assertThat(board.isConnect4(Color.RED), is(true));
    }

    @Test
    public void testGivenBoardWhenIsInverseDiagonalConncect4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                " YY RR ",
                " RRYYY ",
                " YRYRY ",
                "YRYRRRY").build();
        board.putToken(3, Color.YELLOW);
        assertThat(board.isConnect4(Color.YELLOW), is(true));
    }

    // Draw 
    @Test
    public void testGivenEmptyBoardWhenIsFullDrawIsFalse() {
        Board board = this.boardBuilder.build();
        assertThat(board.isDraw(), is(false));
    }

    @Test
    public void testGivenExampleBoardWhenIsFullDrawIsFalse() {
        Board board = getExamplBoard();
        assertThat(board.isDraw(), is(false));
    }

    @Test
    public void testGivenFullBoardWhenIsFullDrawIsTrue() {
        Board board = this.boardBuilder.rows(
                "RRRYRRY",
                "RRYYRRY",
                "RRYYRRY",
                "YYRRYYR",
                "YYRRYYR",
                "YYRRYYR").build();
        assertThat(board.isDraw(), is(true));
    }

    // Example board
    private Board getExamplBoard(){
        return this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                " R     ",
                " RY    ",
                "YRY    ").build();
    }
}