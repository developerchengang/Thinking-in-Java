package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

/****************** Exercise 7 *****************
 * Add a new type of Instrument to Music3.java
 * and verify that polymorphism works for your
 * new type.
 ***********************************************//****************** Exercise 7 *****************
 * Add a new type of Instrument to Music3.java
 * and verify that polymorphism works for your
 * new type.
 ***********************************************/

public class E07_NewInstrument {
    static Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind(),
            new Electronic()
    };
    public static void main(String args[]) {
        for(Instrument i : orchestra) {
            i.play(Note.MIDDLE_C);
            i.adjust();
            print(i);
        }
    }
}

/* output:
 * Wind.play() MIDDLE_C
 * Wind
 * Percussion.play() MIDDLE_C
 * Percussion
 * Stringed.play() MIDDLE_C
 * Stringed
 * Brass.play() MIDDLE_C
 * Brass.adjust()
 */