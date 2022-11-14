package com.connect4.views;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MessageTest {
    
    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.RESUME.toString(), is("Do you want to continue"));
    }
}
