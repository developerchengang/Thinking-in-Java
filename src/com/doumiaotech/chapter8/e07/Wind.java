package com.doumiaotech.chapter8.e07;

import static net.mindview.util.Print.print;

public class Wind extends Instrument {

    void play(Note n) {
        print("Wind.play() " + n);
    }

    public String toString() {
        return "Wind";
    }

}
