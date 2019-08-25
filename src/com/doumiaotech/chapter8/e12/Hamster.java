package com.doumiaotech.chapter8.e12;

import static net.mindview.util.Print.print;

public class Hamster extends Rodent {
    Member m1 = new Member("h1"), m2 = new Member("h2");

    public Hamster() {
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
