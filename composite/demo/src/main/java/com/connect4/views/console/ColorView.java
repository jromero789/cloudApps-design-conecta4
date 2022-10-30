package com.connect4.views.console;

import com.connect4.types.Color;
import com.utils.views.Console;

public class ColorView {
    
    void write(Color color){
        Console.getInstance().write(color.getColorChar());
    }
}
