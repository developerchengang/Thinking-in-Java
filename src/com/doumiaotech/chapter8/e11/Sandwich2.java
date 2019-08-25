package com.doumiaotech.chapter8.e11;

import static net.mindview.util.Print.print;

public class Sandwich2 extends PortableLunch {
    Bread b = new Bread();
    Cheese c = new Cheese();
    Lettuce l = new Lettuce();
    Pickle p = new Pickle();

    Sandwich2() {
        print("Sandwich()");
    }
}
