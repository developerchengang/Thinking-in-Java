package com.doumiaotech.chapter8.e12;

import static net.mindview.util.Print.print;

public class Gerbil extends Rodent {

    Member m1 = new Member("g1"), m2 = new Member("g2");

    public Gerbil() {
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
