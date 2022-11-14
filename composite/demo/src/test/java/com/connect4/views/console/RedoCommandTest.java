package com.connect4.views.console;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.controllers.PlayController;
import com.connect4.types.Color;
import com.connect4.views.Message;
import com.utils.models.CommandTest;


@ExtendWith(MockitoExtension.class)
public class RedoCommandTest extends CommandTest {

    @Mock
    private PlayController playController;

    @Override
    public Command getCommand() {
        return new RedoCommand(playController);
    }

    @Override
    public boolean isActive() {
        return this.getCommand().isActive();
    }

    @Override
    public String getTitle() {
        return Message.REDO_COMMAND.toString();
    }

    @Test
    public void testGivenUndoCommandWhenExecuteThenAdd() {
        when(this.playController.getColor(any())).thenReturn(Color.RED);
        this.getCommand().execute();
        verify(this.playController).redo();
    }
    
}
