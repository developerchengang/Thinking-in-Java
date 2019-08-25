package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

public class Percussion extends Instrument {
    void play(Note n) {
        print("Percussion.play() " + n);
    }

    public String toString() {
        return "Percussion";
    }
}
