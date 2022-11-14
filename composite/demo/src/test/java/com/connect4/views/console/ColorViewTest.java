package com.connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.connect4.types.Color;
import com.utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ColorViewTest {

    @Mock
    private Console console;

    private ColorView colorView;

    @BeforeEach
    public void beforeEach() {
        this.colorView = new ColorView();
    }

    @Test
    public void testGivenColorWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write(Color.RED);
            this.colorView.write(Color.YELLOW);
            this.colorView.write(Color.NULL);
            verify(this.console).write("R");
            verify(this.console).write("Y");
            verify(this.console).write(" ");
        }
    }

}
