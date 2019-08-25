package com.doumiaotech.chapter8.e09;

import static net.mindview.util.Print.print;

public class Gerbil extends Rodent {
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
