package com.doumiaotech.chapter8.e02;

import static net.mindview.util.Print.print;

public class Circle extends Shape {
    @Override
    public void draw() {
        print("Circle.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }
}
