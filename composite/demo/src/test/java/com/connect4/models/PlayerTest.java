package com.connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.connect4.types.Color;
import com.connect4.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayerTest {

    private final Color COLOR = Color.RED;
    private PlayerBuilder playerBuilder;

    @BeforeEach
    public void BeforeEach() {
        this.playerBuilder = new PlayerBuilder().color(this.COLOR);
    }

    @Test
    public void testGivenNewPlayerWhenGetColorThenReturnTheColor() {
        Player player = this.playerBuilder.build();
        assertThat(player.getColor(), is(Color.RED));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        int column = 2;
        Player player = this.playerBuilder.build();
        assertThat(player.getPutTokenError(column), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorNegativeThenErrorColumnInvalid() {
        int column = -1;
        Player player = this.playerBuilder.build();
        assertThat(player.getPutTokenError(column), is(Error.COLUMN_INVALID));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorOutOfRangeThenErrorColumnInvalid() {
        int column = 8;
        Player player = this.playerBuilder.build();
        assertThat(player.getPutTokenError(column), is(Error.COLUMN_INVALID));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorColumnFull() {
        Player player = this.playerBuilder.rows(
            " Y     ",
            " R     ",
            " Y     ",
            " R     ",
            " Y     ",
            " R     "
        ).build();
        assertThat(player.getPutTokenError(1), is(Error.COLUMN_FULL));
    }
}
