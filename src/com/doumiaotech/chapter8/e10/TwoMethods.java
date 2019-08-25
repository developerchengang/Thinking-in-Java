package com.doumiaotech.chapter8.e10;

public class TwoMethods {
    public void m1() {
        System.out.println("Inside m1, calling m2");
        m2();
    }
    public void m2() {
        System.out.println("Inside m2");
    }
}
