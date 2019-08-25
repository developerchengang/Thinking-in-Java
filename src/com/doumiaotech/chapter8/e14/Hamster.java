package com.doumiaotech.chapter8.e14;

import static net.mindview.util.Print.print;

public class Hamster extends Rodent {
    private SharedMember m;
    NonSharedMember m1 = new NonSharedMember("h1"),
            m2 = new NonSharedMember("h2");

    public Hamster(SharedMember sm) {
        super(sm);
        print("Hamster constructor");
    }

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
