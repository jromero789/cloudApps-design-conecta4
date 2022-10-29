package views.console;

import types.Color;
import utils.views.Console;

public class ColorView {
    
    void write(Color color){
        Console.getInstance().write(color.getColorChar());
    }
}
