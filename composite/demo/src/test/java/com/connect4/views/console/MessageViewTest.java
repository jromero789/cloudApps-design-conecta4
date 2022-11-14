package com.connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.views.Message;
import com.utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MessageViewTest {

    @Mock
    private Console console;

    private MessageView messageView;

    @BeforeEach
    public void beforeEach() {
        this.messageView = new MessageView();
    }

    @Test
    public void testGivenNewMessageWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.write(Message.ENTER_COLUMN_TO_PUT);
            verify(this.console).write("Enter a column to put a token:");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.ENTER_COLUMN_TO_PUT);
            verify(this.console).writeln("Enter a column to put a token:");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnPlayerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String player = "R";
            this.messageView.writeln(Message.PLAYER_WIN, player);
            verify(this.console).writeln(player + " player: You win!!! :-)");
        }
    }
    
}

