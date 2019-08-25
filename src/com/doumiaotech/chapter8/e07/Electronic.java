package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

public class Electronic extends Instrument {
    void play(Note n) {
        print("Electronic.play() " + n);
    }

    public String toString() {
        return "Electronic";
    }
}
