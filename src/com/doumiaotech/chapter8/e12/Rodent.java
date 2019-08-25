package com.doumiaotech.chapter8.e12;

import static net.mindview.util.Print.print;

public class Rodent {
    Member m1 = new Member("r1"), m2 = new Member("r2");

    public Rodent() {
        print("Rodent constructor");
    }

    public void hop() {
        print("Rodent hopping");
    }

    public void scurry() {
        print("Rodent scurrying");
    }

    public void reproduce() {
        print("Making more Rodents");
    }

    public String toString() {
        return "Rodent";
    }
}
