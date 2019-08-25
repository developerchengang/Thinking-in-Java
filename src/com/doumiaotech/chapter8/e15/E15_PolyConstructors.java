package com.doumiaotech.chapter8.e15;

/****************** Exercise 15 *****************
 * Add a RectangularGlyph to PolyConstructors.java
 * and demonstrate the problem described in this
 * section.
 ***********************************************/

public class E15_PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(2,2);
    }
}

/* output:
 * Glyph() before draw()
 * RoundGlyph.draw(), radius = 0
 * Glyph() after draw()
 * RoundGlyph.RoundGlyph(), radius = 5
 * Glyph() before draw()
 * RectangularGlyph.draw(), area = 0
 * Glyph() after draw()
 * RectangularGlyph.RectangularGlyph(), width = 2, height = 2
 */