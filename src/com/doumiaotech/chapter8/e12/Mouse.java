package com.doumiaotech.chapter8.e12;

import static net.mindview.util.Print.print;

public class Mouse extends Rodent {
    Member m1 = new Member("m1"), m2 = new Member("m2");

    public Mouse() {
        print("Mouse constructor");
    }

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
