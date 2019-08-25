package com.doumiaotech.chapter8.e09;

import static net.mindview.util.Print.print;

public class Hamster extends Rodent {
    public void hop() {
        print("Hamster hopping");
    }

    public void scurry() {
        print("Hamster scurrying");
    }

    public void reproduce() {
        print("Making more Hamsters");
    }

    public String toString() {
        return "Hamster";
    }
}
