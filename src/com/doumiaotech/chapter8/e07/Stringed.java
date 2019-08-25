package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

public class Stringed extends Instrument {
    void play(Note n) {
        print("Stringed.play() " + n);
    }

    public String toString() {
        return "Stringed";
    }
}
