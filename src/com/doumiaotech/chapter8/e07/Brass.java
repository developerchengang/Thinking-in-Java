package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

public class Brass extends Instrument {
    void play(Note n) {
        print("Brass.play() " + n);
    }

    void adjust() {
        print("Brass.adjust()");
    }
}
