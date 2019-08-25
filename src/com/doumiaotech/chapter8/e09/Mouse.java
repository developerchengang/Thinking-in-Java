package com.doumiaotech.chapter8.e09;

import static net.mindview.util.Print.print;

public class Mouse extends Rodent {
    public void hop() {
        print("Mouse hopping");
    }

    public void scurry() {
        print("Mouse scurrying");
    }

    public void reproduce() {
        print("Making more Mice");
    }

    public String toString() {
        return "Mouse";
    }
}
