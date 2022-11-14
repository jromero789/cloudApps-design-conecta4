package com.connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.connect4.types.Color;
import com.utils.models.Cell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistryTest {

    private Game game;
    private Registry registry;

    @BeforeEach
    public void beforeEach() {
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    @Test
    public void givenEmptyRegistryWhenUndoableOrRedoableThenFalse() {
        assertThat(this.registry.undoable(), is(false));
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    public void givenRegistryWhenResetThenIsNotUndoableNorRedoable() {
        this.registry.register();
        this.registry.reset();
        assertThat(this.registry.undoable(), is(false));
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    void givenRegistryWhenRegisterThenIsUndoableAndNotRedoable() {
        this.registry.register();
        assertThat(this.registry.undoable(), is(true));
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    void givenRegistryWhenUndoAndRegisterThenNotRedoable() {
        this.registry.register();
        this.registry.undo();
        this.registry.register();
        assertThat(this.registry.redoable(), is(false));
    }

    @Test
    void givenRegistryWhenUndoThenGameChangedCorrectly() {
        this.game = new GameBuilder().turn(Color.RED).build();
        this.registry = new Registry(this.game);
        this.game.putToken(1);
        this.game.next();
        this.registry.register();
        this.registry.undo();
        assertThat(this.game.getActiveColor(), is(Color.RED));
        assertThat(this.game.getColor(new Cell(0,1)), is(Color.NULL));
    }

    @Test
    void givenRegistryWhenRedoThenGameChangedCorrectly() {
        this.game = new GameBuilder().turn(Color.RED).build();
        this.registry = new Registry(this.game);
        this.game.putToken(1);
        this.game.next();
        this.registry.register();
        this.registry.undo();
        this.registry.redo();
        assertThat(this.game.getActiveColor(), is(Color.YELLOW));
        assertThat(this.game.getColor(new Cell(0,1)), is(Color.RED));
    }

}