package com.doumiaotech.chapter8.e15;

import static net.mindview.util.Print.print;

public class Glyph {
    void draw() {
        print("Glyph.draw()");
    }

    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}
