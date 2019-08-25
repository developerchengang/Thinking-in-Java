package com.doumiaotech.chapter8.e06;

import static net.mindview.util.Print.print;

public class Woodwind extends Instrument {
    void play(Note n) {
        print("Woodwind.play() " + n);
    }

    public String toString() {
        return "Woodwind";
    }
}
