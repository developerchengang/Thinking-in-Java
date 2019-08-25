package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

public class Instrument {
    void play(Note n) {
        print("Instrument.play() " + n);
    }

    public String toString() {
        return "Instrument";
    }

    void adjust() {
    }
}
