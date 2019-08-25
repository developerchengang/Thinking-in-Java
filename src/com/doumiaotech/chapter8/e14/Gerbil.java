package com.doumiaotech.chapter8.e14;

import static net.mindview.util.Print.print;

public class Gerbil extends Rodent {

    private SharedMember m;

    NonSharedMember m1 = new NonSharedMember("g1"),
            m2 = new NonSharedMember("g2");

    public Gerbil(SharedMember sm) {
        super(sm);
        print("Gerbil constructor");
    }

    public void hop() {
        print("Gerbil hopping");
    }

    public void scurry() {
        print("Gerbil scurrying");
    }

    public void reproduce() {
        print("Making more Gerbils");
    }

    public String toString() {
        return "Gerbil";
    }
}
