package com.connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.views.ErrorView;
import com.connect4.types.Error;
import com.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    private Console console;

    private ErrorView errorView;

    @BeforeEach
    public void beforeEach() {
        this.errorView = new ErrorView();
    }

    @Test
    public void testGivenCorrectErrorWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.COLUMN_INVALID);
            verify(this.console).writeln("The column is invalid");
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NULL);
            verify(this.console, never()).writeln(anyString());
        }
    }

}
