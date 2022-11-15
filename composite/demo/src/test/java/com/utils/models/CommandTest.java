package com.utils.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class CommandTest {
    
    private static final String TITLE = "Command Title";

    public abstract Command getCommand();

    @Test
	public void testGivenCommandWhenIsActiveThenTrue() {
        assertThat(this.getCommand().isActive(), is(this.isActive()));
    }

    public boolean isActive() {
        return true;
    }

    @Test
	public void testGivenCommandWhenGetTitleThenReturn() {
		assertThat(this.getCommand().getTitle(), is(this.getTitle()));
	}

    public String getTitle() {
        return CommandTest.TITLE;
    }

}
