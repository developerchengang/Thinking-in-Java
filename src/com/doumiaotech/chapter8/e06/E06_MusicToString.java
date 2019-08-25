package com.doumiaotech.chapter8.e06;

/****************** Exercise 6 *****************
 * Change Music3.java so what() becomes the root
 * Object method toString(). Print the Instrument
 * objects using System.out.println() (without
 * any casting).
 ***********************************************/

public class E06_MusicToString {
    static Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind()
    };
    public static void printAll(Instrument[] orch) {
        for(Instrument i : orch)
            System.out.println(i);
    }
    public static void main(String args[]) {
        printAll(orchestra);
    }
}

/* output:
 * Wind
 * Percussion
 * Stringed
 * Wind
 * Woodwind
 */