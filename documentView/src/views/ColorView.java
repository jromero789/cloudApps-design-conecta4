package views;


import types.Color;
import utils.views.Console;

public class ColorView {
    
    void write(Color color){
        
        String string = color.getColorChar();
        Console.getInstance().write(string);
    }
}
