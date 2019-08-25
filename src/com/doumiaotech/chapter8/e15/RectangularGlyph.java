package com.doumiaotech.chapter8.e15;

import static net.mindview.util.Print.print;

public class RectangularGlyph extends Glyph {

    private int width = 4;
    private int height = 5;

    RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
        print("RectangularGlyph.RectangularGlyph(), width = " +
                width + ", height = " + height);
    }

    void draw() {
        print("RectangularGlyph.draw(), area = " + width *
                height);
    }

}
