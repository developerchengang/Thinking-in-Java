package com.doumiaotech.chapter8.e14;

import static net.mindview.util.Print.print;

public class Rodent {
    private SharedMember m;
    NonSharedMember m1 = new NonSharedMember("r1"),
            m2 = new NonSharedMember("r2");

    public Rodent(SharedMember sm) {
        print("Rodent constructor");
        m = sm;
        m.addRef();
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

    protected void dispose() {
        print("Disposing " + this);
        m.dispose();
    }

    public String toString() {
        return "Rodent";
    }
}
