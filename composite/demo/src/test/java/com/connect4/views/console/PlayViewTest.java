package com.connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.controllers.PlayController;
import com.connect4.models.Session;
import com.connect4.types.Color;
import com.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Console console;

    @Spy
    private Session session;

    private PlayController playController;
    private PlayView playView;


    @BeforeEach
    public void beforeEach(){
        this.playController = new PlayController(this.session);
        this.playView = new PlayView();
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.getActiveColor()).thenReturn(Color.YELLOW);
            when(this.session.isConnect4()).thenReturn(true);
            this.playView.interact(this.playController);
            verify(this.console).writeln("Y player: You win!!! :-)");
        }
    }

}