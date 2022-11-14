package com.connect4.views.console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.controllers.PlayController;
import com.connect4.models.Session;
import com.connect4.views.Message;
import com.utils.models.CommandTest;
import com.utils.views.Console;


@ExtendWith(MockitoExtension.class)
public class ActionCommandTest extends CommandTest {

    @Mock
    private Console console;

    private PlayController playController;

    @BeforeEach
    public void beforeEach() {
        this.playController = spy(new PlayController(new Session()));
    }

    @Override
    public Command getCommand() {
        return new ActionCommand(playController);
    }

    @Override
    public boolean isActive() {
        return this.getCommand().isActive();
    }

    @Override
    public String getTitle() {
        return Message.ACTION_COMMAND.toString();
    }

    @Test
    public void testGivenProposeCommandWhenExecuteThenAdd() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(2);
            this.getCommand().execute();
            verify(this.playController).putToken(1);
            verify(this.playController).next();
        }
    }
    
}
