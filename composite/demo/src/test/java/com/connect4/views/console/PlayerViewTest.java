package com.connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.controllers.PlayController;
import com.connect4.views.Message;
import com.connect4.types.Error;
import com.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {

    final static int COLUMN = 0;

    @Mock
    private Console console;

    @Mock
    private PlayController playController;

    private PlayerView playerView;

    @BeforeEach
    public void beforeEach() {
        this.playerView = spy(new PlayerView(this.playController));
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenPutToken() {
        doReturn(PlayerViewTest.COLUMN).when(playerView).getColumn(any());
        when(this.playController.getPutTokenError(any(int.class))).thenReturn(Error.NULL);
        this.playerView.interact();
        verify(this.playController).putToken(PlayerViewTest.COLUMN);
    }

    @Test
    public void testGivenUserPlayerViewWhenGetColumnThenReturn() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(
                    PlayerViewTest.COLUMN + 1
            );
            assertThat(this.playerView.getColumn(Message.ENTER_COLUMN_TO_PUT), is(PlayerViewTest.COLUMN));
        }
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenPutTokenError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            doReturn(PlayerViewTest.COLUMN).when(this.playerView).getColumn(any());
            when(this.playController.getPutTokenError(any(int.class))).thenReturn(Error.COLUMN_INVALID, Error.NULL);
            this.playerView.interact();
            verify(this.console).writeln("The column is invalid");
        }
    }
}