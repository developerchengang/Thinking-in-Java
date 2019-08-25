package com.doumiaotech.chapter8.e14;

import static net.mindview.util.Print.print;

public class Mouse extends Rodent {

    NonSharedMember m1 = new NonSharedMember("m1"),
            m2 = new NonSharedMember("m2");

    public Mouse(SharedMember sm) {
        super(sm);
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
